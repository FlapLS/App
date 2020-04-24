package commands;

import managers.CollectionManager;
import managers.IOManager;

import java.util.Set;

/**
 * Класс, описывающий конкретную реализацию команды help.
 *
 * @author Базанов Евгений
 */
public class Help extends Command {
    private Set<Command> commands;

    public Help(CollectionManager manager, IOManager ioManager, Set<Command> commands) {
        super("help",
                "вывести справку по доступным командам",
                "",
                manager,
                ioManager);
        this.commands = commands;
    }

    @Override
    public void execute(String... args) {
        commands.forEach(command -> io.result.printf("%s %s : %s%n", command.commandName, command.arguments, command.info));
    }
}