package commands;

import entities.SpaceMarine;
import managers.CollectionManager;
import managers.IOManager;

import java.util.stream.Collectors;

/**
 * Класс, описывающий конкретную реализацию команды print unique chapter.
 *
 * @author Базанов Евгений.
 */
public class PrintUniqueChapter extends Command {
    public PrintUniqueChapter(CollectionManager manager, IOManager ioManager) {
        super("print_unique_chapter",
                "вывести уникальные значения поля chapter всех элементов в коллекции",
                "",
                manager,
                ioManager);
    }

    @Override
    public void execute(String... args) {
        manager.getCollection().getMarines().stream()
                .map(SpaceMarine::getChapter)
                .collect(Collectors.toSet())
                .forEach(io.getResult()::println);
    }
}