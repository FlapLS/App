package commands;

import managers.CollectionManager;
import managers.IOManager;

/**
 * Класс, описывающий конкретную реализацию команды show.
 *
 * @author Базанов Евгений.
 */
public class Show extends Command {
    public Show(CollectionManager manager, IOManager ioManager) {
        super("show",
                "вывести в стандартный поток вывода все элементы коллекции в строковом представлении",
                "",
                0,
                manager,
                ioManager);
    }

    @Override
    public void execute(String... args) {
        io.getResult().println(manager.getCollection().toString());
    }
}