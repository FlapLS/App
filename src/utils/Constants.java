package utils;

import java.io.File;
import java.nio.file.Paths;

/**
 * Классе хранит путь к файлу коллекции по умолчанию, и прочитанный файл коллекции по умолчанию.
 *
 * @author Базанов Евгений
 */
public class Constants {
    public static final String DEFAULT_PATH = Paths.get("./resources/default.xml").toAbsolutePath().toString();
    public static final File DEFAULT_FILE = new File(DEFAULT_PATH);
}
