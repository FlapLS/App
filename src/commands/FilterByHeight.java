package commands;

import managers.CollectionManager;
import managers.IOManager;

/**
 * Класс, описывающий конкретную реализацию команды filter by height.
 *
 * @author Базанов Евгений.
 */
public class FilterByHeight extends Command {
    public FilterByHeight(CollectionManager manager, IOManager IOManager) {
        super("filter_by_height",
                "вывести элементы, значение поля height которых равно заданному",
                "height",
                manager,
                IOManager);
    }

    @Override
    public void execute(String... args) {
        if (args.length != 1) {
            io.result.println("Команда принимает только один аргумент");
            return;
        }
        try {
            long expectedHeight = Long.parseLong(args[0]);
            manager.getCollection().getMarines().stream()
                    .filter(marine -> marine.getHeight() == expectedHeight)
                    .forEach(io.result::println);
        } catch (NumberFormatException e) {
            io.result.println("Команда принимает только один цельночисленный id");
        }
    }
}