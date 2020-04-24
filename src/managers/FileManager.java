package managers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static utils.Constants.DEFAULT_FILE;
import static utils.Constants.DEFAULT_PATH;

/**
 * Класс, работающий с файлом
 *
 * @author Базанов Евгений
 */
public class FileManager {
    private String path;
    private File file;

    public FileManager(String[] args) {
        if (args.length == 0) {
            System.err.println("Не переданны аргументы командной строки, используется стандартный файл");
            this.path = DEFAULT_PATH;
            this.file = DEFAULT_FILE;
            return;
        }

        String stringPath = args[0];
        final Path path = Paths.get(stringPath);
        if (!Files.exists(path) || !Files.isReadable(path) || !Files.isWritable(path)) {
            System.err.println("Ошибка в обработке файла, используется стандартный файл");
            this.path = DEFAULT_PATH;
            this.file = DEFAULT_FILE;
            return;
        }

        this.path = stringPath;
        this.file = new File(stringPath);
    }

    public String getPath() {
        return path;
    }

    public File getFile() {
        return file;
    }
}