package commands;

import entities.SpaceMarineInitializer;
import managers.CollectionManager;
import managers.IOManager;

/**
 * Класс, описывающий конкретную реализацию команды update.
 *
 * @author Базанов Евгений.
 */
public class Update extends Command {
    public Update(CollectionManager manager, IOManager ioManager) {
        super("update",
                "обновить значение элемента коллекции, id которого равен заданному",
                "id {element}",
                1,
                manager,
                ioManager);
    }

    @Override
    public void execute(String... args) {
        try {
            boolean isDeleted = manager.getCollection()
                    .removeIf(marine -> marine.getId() == Integer.parseInt(args[0]));
            if (!isDeleted) {
                io.getResult().println("Не найден элемент с переданным id");
                return;
            }
            manager.getCollection().addMarine(new SpaceMarineInitializer(io, manager.getFreeRandomId()).initialize());
            io.getResult().println("Элемент успешно обновлен");
        } catch (NumberFormatException e) {
            io.getResult().println("Команда принимает только один цельночисленный id");
        }
    }
}