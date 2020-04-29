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
            doIterationWithoutCommands();
        }
    }

    /**
     * Метод,реализуюший выполнение команды execute script.
     */
    public void executeScript() {
        while (io.inputReady()) {
            doIterationWithoutCommands("execute_script");

        }
    }

    /**
     * Метод, выполняющий одну итерацию с прочтением команды, исключив список комманд.
     *
     * @param excludedCommands команды которые не могут быть выполненны в рамках итерации
     */
    public void doIterationWithoutCommands(String... excludedCommands) {
        String enteredLine = io.nextLine().trim();
        if (enteredLine.equals("")) return;
        String[] rawCommand = enteredLine.replaceAll(" +", " ").split(" ");
        String commandName = rawCommand[0];
        String[] commandArgs = Arrays.copyOfRange(rawCommand, 1, rawCommand.length);
        Command ongoingCommand;
        try {
            ongoingCommand = findCommand(commandName);
        } catch (CommandNotFoundException e) {
            io.getResult().println("Неизвестная команда, чтобы посмотреть список команд введите help");
            return;
        }
        if (commandArgs.length != ongoingCommand.getArgumentsCount()) {
            io.getResult().printf("Переданно неверное количество аргументов, ожидается: " + ongoingCommand.getArgumentsCount());
            return;
        }
        if (Arrays.asList(excludedCommands).contains(commandName)) {
            io.getResult().println("Невозможно исполнить команду " + commandName);
            return;
        }
        ongoingCommand.execute(commandArgs);
        lastCommands.addCommand(ongoingCommand);
    }

    /**
     * Метод,реализуюший идентификацию команды
     *
     * @param commandName название команды.
     *
     * @return название комманды или исключение в случаи не прпавильного ввроа
     *
     * @throws CommandNotFoundException в случаи отсутствия команды
     */
    public Command findCommand(String commandName) throws CommandNotFoundException {
        return commands.stream().filter(c -> c.getCommandName().equals(commandName))
                .findAny().orElseThrow(() -> new CommandNotFoundException());
    }


}