package commands;

import managers.CollectionManager;
import managers.IOManager;
/**
 * Класс описывающий конкретную реализацию команды remove by id.
 *
 * @author Базанов Евгений.
 */
public class RemoveById extends Command {
    public RemoveById(CollectionManager manager, IOManager ioManager) {
        super("remove_by_id",
                "удалить элемент из коллекции по его id",
                "id",
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
            if (isDeleted) {
                io.result.println("Элемент успешно удален");
            } else {
                io.result.println("Не найден элемент с переданным id");
            }
        } catch (NumberFormatException e) {
            io.result.println("Команда принимает только один цельночисленный id");
        }
    }
}