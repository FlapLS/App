package commands;

import managers.CollectionManager;
import managers.IOManager;

/**
 * Абстрактный класс, от которого наследуются все команды.
 *
 * @author Базанов Евгений.
 */
public abstract class Command {
    public final String commandName;
    public final String info;
    public final String arguments;
    protected final CollectionManager manager;
    protected final IOManager io;

    /**
     * Конструктор, который будет вызываться при наследования свойст абстрактного класса Command.
     *
     * @param commandName название команды.
     * @param info        описание команды.
     * @param arguments   аргументы, принимаемые командой.
     * @param manager     менеджер коллекции с которой будет работать команда.
     * @param scanner     менеджер который будет работать с потокамми ввода/ввыода.
     */
    protected Command(String commandName, String info, String arguments, CollectionManager manager, IOManager scanner) {
        this.commandName = commandName;
        this.info = info;
        this.arguments = arguments;
        this.manager = manager;
        io = scanner;
    }

    /**
     * Абстрактный метод, определяющий реализацию выполняемой команды.
     *
     * @param args обозначает аргументы для введенной команды.
     */
    public abstract void execute(String... args);
}