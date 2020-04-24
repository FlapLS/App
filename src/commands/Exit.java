package commands;

import managers.CollectionManager;
import managers.IOManager;
/**
 * Класс описывающий конкретную реализацию команды exit.
 *
 * @author Базанов Евгений
 */
public class Exit extends Command {
    public Exit(CollectionManager manager, IOManager ioManager) {
        super("exit",
                "завершить программу (без сохранения в файл)",
                "",
                manager,
                ioManager);
    }

    @Override
    public void execute(String... args) {
        System.exit(0);
    }
}