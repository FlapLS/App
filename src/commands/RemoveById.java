package commands;

import managers.CollectionManager;
import managers.IOManager;

/**
 * Класс, описывающий конкретную реализацию команды remove by id.
 *
 * @author Базанов Евгений.
 */
public class RemoveById extends Command {
    public RemoveById(CollectionManager manager, IOManager ioManager) {
        super("remove_by_id",
                "удалить элемент из коллекции по его id",
                "id",
                1,
                manager,
                ioManager);
    }

    @Override
    public void execute(String... args) {
        try {
            boolean isDeleted = manager.getCollection()
                    .removeIf(marine -> marine.getId() == Integer.parseInt(args[0]));
            if (isDeleted) {
                io.getResult().println("Элемент успешно удален");
            } else {
                io.getResult().println("Не найден элемент с переданным id");
            }
        } catch (NumberFormatException e) {
            io.getResult().println("Команда принимает только один цельночисленный id");
        }
    }
}