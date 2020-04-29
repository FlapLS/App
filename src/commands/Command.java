package commands;

import managers.CollectionManager;
import managers.IOManager;

/**
 * Абстрактный класс, от которого наследуются все команды.
 *
 * @author Базанов Евгений.
 */
public abstract class Command {
    protected final String commandName;
    protected final String info;
    protected final String arguments;
    protected final int argumentsCount;
    protected final CollectionManager manager;
    protected final IOManager io;

    /**
     * Конструктор, который будет вызываться при наследования свойст абстрактного класса Command.
     *
     * @param commandName    название команды.
     * @param info           описание команды.
     * @param arguments      аргументы, принимаемые командой.
     * @param argumentsCount колиество аргументов у команды.
     * @param manager        менеджер коллекции с которой будет работать команда.
     * @param scanner        менеджер который будет работать с потокамми ввода/ввыода.
     */
    protected Command(String commandName, String info, String arguments, int argumentsCount, CollectionManager manager, IOManager scanner) {
        this.commandName = commandName;
        this.info = info;
        this.arguments = arguments;
        this.argumentsCount = argumentsCount;
        this.manager = manager;
        io = scanner;
    }

    public String getCommandName() {
        return commandName;
    }

    public int getArgumentsCount() {
        return argumentsCount;
    }

    /**
     * Абстрактный метод, определяющий реализацию выполняемой команды.
     *
     * @param args обозначает аргументы для введенной команды.
     */
    public abstract void execute(String... args);
}