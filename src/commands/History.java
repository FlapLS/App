package commands;

import managers.CollectionManager;
import managers.IOManager;
import utils.CommandsHistory;

/**
 * Класс описывающий конкретную реализацию команды history.
 *
 * @author Базанов Евгений
 */
public class History extends Command {
    private CommandsHistory history;

    public History(CollectionManager manager, IOManager ioManager, CommandsHistory history) {
        super("history",
                " вывести последние 7 команд (без их аргументов)",
                "",
                manager,
                ioManager);
        this.history = history;
    }

    @Override
    public void execute(String... args) {
        io.result.println(history.toString());
    }
}