package managers;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Класс для управления потоками ввода-вывода
 *
 * @author Базанов Евгений
 */
public class IOManager {
    private final PrintStreamWrapper interactive;
    private final PrintStreamWrapper result;
    private final Scanner input;

    public IOManager(PrintStream interactive, PrintStream result, Scanner input) {
        this.interactive = new PrintStreamWrapper(interactive);
        this.result = new PrintStreamWrapper(result);
        this.input = input;
    }

    /**
     * Метод, получает строку из потока ввода
     */
    public String nextLine() {
        return input.nextLine();
    }

    /**
     * Метод, проверяет готовность потока ввода
     */
    public boolean inputReady() {
        return input.hasNext();
    }

    /**
     * Метод в интерактивном режиме запрашивает параметр
     *
     * @param paramName имя параметр
     *
     * @return введеную пользователем строку
     */
    public String requestParameter(String paramName) {
        getInteractive().printf("Введите %s: ", paramName);
        return input.nextLine();
    }

    public PrintStreamWrapper getInteractive() {
        return interactive;
    }

    public PrintStreamWrapper getResult() {
        return result;
    }

    /**
     * Класс обертка над потоком вывода, сохраняющая его состояние.
     */
    public static class PrintStreamWrapper {
        private final PrintStream wrapped;

        private PrintStreamWrapper(PrintStream wrapped) {
            this.wrapped = wrapped;
        }

        public void println(String string) {
            wrapped.println(string);
        }

        public void println(Object x) {
            wrapped.println(x);
        }

        public void printf(String format, Object... args) {
            wrapped.printf(format, args);
        }
    }
}