package managers;

import commands.*;
import utils.CommandsHistory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Класс, предназначеный для вызова команд, работающих с колекцией.
 *
 * @author Базанов Евгений.
 */
public class CommandManager {
    private final Set<Command> commands = new HashSet<>();
    private final CommandsHistory lastCommands = new CommandsHistory();
    private final IOManager io;


    public CommandManager(CollectionManager manager, IOManager io) {
        this.io = io;
        commands.add(new Info(manager, io));
        commands.add(new Exit(manager, io));
        commands.add(new Show(manager, io));
        commands.add(new History(manager, io, lastCommands));
        commands.add(new Help(manager, io, commands));
        commands.add(new Add(manager, io));
        commands.add(new Clear(manager, io));
        commands.add(new RemoveById(manager, io));
        commands.add(new RemoveLower(manager, io));
        commands.add(new PrintDescending(manager, io));
        commands.add(new PrintUniqueChapter(manager, io));
        commands.add(new FilterByHeight(manager, io));
        commands.add(new Update(manager, io));
        commands.add(new AddIfMax(manager, io));
        commands.add(new Save(manager, io));
        commands.add(new ExecuteScript(manager, io));

    }

    /**
     * Метод,реализуюший выполнение команд.
     */
    public void start() {
        while (true) {
            String enteredLine = io.nextLine().trim();
            if (enteredLine.equals("")) continue;
            String[] rawCommand = enteredLine.replaceAll(" +", " ").split(" ");
            String commandName = rawCommand[0];
            String[] commandArgs = Arrays.copyOfRange(rawCommand, 1, rawCommand.length);
            Command ongoingCommand = findCommand(commandName);
            if (ongoingCommand == null) {
                io.getResult().println("Неизвестная команда, чтобы посмотреть список команд введите help");
                continue;
            }
            if (commandArgs.length != ongoingCommand.getArgumentsCount()) {
                io.getResult().printf("Переданно неверное количество аргументов, ожидается: " + ongoingCommand.getArgumentsCount());
                continue;
            }
            ongoingCommand.execute(commandArgs);
            lastCommands.addCommand(ongoingCommand);
        }
    }

    /**
     * Метод,реализуюший выполнение команды execute script.
     */
    public void executeScript() {
        do {
            String enteredLine = io.nextLine().trim();
            if (enteredLine.equals("")) continue;
            String[] rawCommand = enteredLine.replaceAll(" +", " ").split(" ");
            String commandName = rawCommand[0];
            String[] commandArgs = Arrays.copyOfRange(rawCommand, 1, rawCommand.length);
            Command ongoingCommand = findCommand(commandName);
            if (ongoingCommand == null) {
                io.getResult().println("Неизвестная команда, чтобы посмотреть список команд введите help");
                continue;
            }
            if (commandName.equals("execute_script")) {
                io.getResult().println("Невозможно исполнить команду execute_script");
                continue;
            }
            if (commandArgs.length != ongoingCommand.getArgumentsCount()) {
                io.getResult().printf("Переданно неверное количество аргументов, ожидается: " + ongoingCommand.getArgumentsCount());
                continue;
            }
            ongoingCommand.execute(commandArgs);
            lastCommands.addCommand(ongoingCommand);
        } while (io.inputReady());
    }

    /**
     * Метод,реализуюший идентификацию команды.
     *
     * @param commandName название команды.
     * @return название комманды или null в случаи неправильного ввода команды.
     */
    public Command findCommand(String commandName) {
        return commands.stream().filter(c -> c.getCommandName().equals(commandName))
                .findAny().orElse(null);
    }


}