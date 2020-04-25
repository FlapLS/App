package commands;

import entities.SpaceMarine;
import entities.SpaceMarineInitializer;
import managers.CollectionManager;
import managers.IOManager;

/**
 * Класс, описывающий конкретную реализацию команды add if max.
 *
 * @author Базанов Евгений.
 */
public class AddIfMax extends Command {
    public AddIfMax(CollectionManager manager, IOManager ioManager) {
        super("add_if_max",
                "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции",
                "{element}",
                manager,
                ioManager);
    }

    @Override
    public void execute(String... args) {
        final SpaceMarine newMarine = new SpaceMarineInitializer(io, manager.getFreeRandomId()).initialize();
        boolean isMax = manager.getCollection().getMarines().stream()
                .noneMatch(marine -> marine.compareTo(newMarine) > 0);
        if (!isMax) {
            io.result.println("Введенный элемент не превышает наибольшее значение в коллекции");
            return;
        }
        manager.getCollection().addMarine(newMarine);
        io.result.println("Новый элемент добавлен в коллекцию");
    }
}