package commands;

import managers.CollectionManager;
import managers.IOManager;

/**
 * Класс, описывающий конкретную реализацию команды save.
 *
 * @author Базанов Евгений.
 */
public class Save extends Command {
    public Save(CollectionManager manager, IOManager ioManager) {
        super("save",
                "сохранить коллекцию в файл",
                "",
                manager,
                ioManager);
    }

    @Override
    public void execute(String... args) {
        manager.save();
        io.getResult().println("Коллекция успешно сохраннена");
    }
}