package commands;

import entities.SpaceMarine;
import entities.SpaceMarineInitializer;
import managers.CollectionManager;
import managers.IOManager;

/**
 * Класс, описывающий конкретную реализацию команды remove lower.
 *
 * @author Базанов Евгений.
 */
public class RemoveLower extends Command {
    public RemoveLower(CollectionManager manager, IOManager ioManager) {
        super("remove_lower",
                "удалить из коллекции все элементы, меньшие, чем заданный",
                "{element}",
                0,
                manager,
                ioManager);
    }

    @Override
    public void execute(String... args) {
        final SpaceMarine compared = new SpaceMarineInitializer(io, manager.getFreeRandomId()).initialize();
        boolean isDeleted = manager.getCollection().removeIf(marine -> (marine.compareTo(compared) < 0));
        if (isDeleted) {
            io.getResult().println("Элемент(ы) успешно удален");
        } else {
            io.getResult().println("Не найдены элементы меньше введенного");
        }
    }
}