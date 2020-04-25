package commands;

import managers.CollectionManager;
import managers.IOManager;

/**
 * Класс, описывающий конкретную реализацию команды clear.
 *
 * @author Базанов Евгений.
 */
public class Clear extends Command {
    public Clear(CollectionManager manager, IOManager ioManager) {
        super("clear",
                "очистить коллекцию",
                "",
                manager,
                ioManager);
    }

    @Override
    public void execute(String... args) {
        manager.clear();
        io.getResult().println("Коллекция очищена");
    }
}