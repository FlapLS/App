package commands;

import entities.SpaceMarine;
import entities.SpaceMarineInitializer;
import managers.CollectionManager;
import managers.IOManager;

/**
 * Класс, описывающий конкретную реализацию команды add.
 *
 * @author Базанов Евгений.
 */
public class Add extends Command {
    public Add(CollectionManager manager, IOManager ioManager) {
        super("add",
                "добавить новый элемент в коллекцию",
                "{element}",
                manager,
                ioManager);
    }

    @Override
    public void execute(String... args) {
        final SpaceMarine marine = new SpaceMarineInitializer(io, manager.getFreeRandomId()).initialize();
        manager.getCollection().addMarine(marine);
        io.getResult().println("Новый элемент добавлен в коллекцию");
    }
}