import commands.Command;
import managers.CollectionManager;
import managers.FileManager;
import managers.IOManager;
import managers.CommandManager;

import java.util.List;
import java.util.Scanner;

import static utils.CommandsListAggregator.createCommandsList;

/**
 * Главный класс программы, метод main котрого реализует работу консольного приложения для управления коллекцией объектов
 * в интерактивном режиме.
 *
 * @author Базанов Евгений.
 */
public class Main {
    public static void main(String[] args) {
        final FileManager fileManager = new FileManager(args);
        final CollectionManager collectionManager = new CollectionManager(fileManager);
        final IOManager ioManager = new IOManager(System.out, System.out, new Scanner(System.in));
        final List<Command> commandsList = createCommandsList(collectionManager, ioManager);
        final CommandManager commandManager = new CommandManager(collectionManager, ioManager, commandsList);

        commandManager.start();
    }
}
