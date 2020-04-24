package managers;

import java.io.PrintStream;
import java.util.Scanner;

//TODO ДЛЕАТЬ DOC
public class IOManager {
    public final PrintStreamWrapper interactive;
    public final PrintStreamWrapper result;
    private final Scanner input;

    public IOManager(PrintStream interactive, PrintStream result, Scanner input) {
        this.interactive = new PrintStreamWrapper(interactive);
        this.result = new PrintStreamWrapper(result);
        this.input = input;
    }

    /**
     * @return
     */
    public String nextLine() {
        return input.nextLine();
    }

    /**
     * @return
     */
    public boolean inputReady() {
        return input.hasNext();
    }

    /**
     * @param paramName
     * @return
     */
    public String requestParameter(String paramName) {
        interactive.printf("Введите %s: ", paramName);
        return input.nextLine();
    }

    public class PrintStreamWrapper {
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