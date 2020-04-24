package commands;

import entities.SpaceMarineInitializer;
import managers.CollectionManager;
import managers.IOManager;

/**
 * Класс, описывающий конкретную реализацию команды update.
 *
 * @author Базанов Евгений
 */
public class Update extends Command {
    public Update(CollectionManager manager, IOManager ioManager) {
        super("update",
                "обновить значение элемента коллекции, id которого равен заданному",
                "id {element}",
                manager,
                ioManager);
    }

    @Override
    public void execute(String... args) {
        if (args.length != 1) {
            io.result.println("Команда принимает только один аргумент");
            return;
        }
        try {
            boolean isDeleted = manager.getCollection()
                    .removeMarineByPredicate(marine -> marine.getId() == Integer.parseInt(args[0]));
            if (!isDeleted) {
                io.result.println("Не найден элемент с переданным id");
                return;
            }
            manager.getCollection().addMarine(new SpaceMarineInitializer(io, manager.getFreeRandomId()).initialize());
            io.result.println("Элемент успешно обновлен");
        } catch (NumberFormatException e) {
            io.result.println("Команда принимает только один цельночисленный id");
        }
    }
}