package managers;

import entities.CollectionSpaceMarines;
import utils.Parser;

import java.time.OffsetDateTime;
import java.util.Random;

import static utils.Parser.parseXmlFile;

/**
 * Класс, предназначенный для управления коллекцией и обладающий свойствами
 * creationTime, filepath
 *
 * @author Базанов Евгений
 */
public class CollectionManager {
    private CollectionSpaceMarines collection;
    private final OffsetDateTime creationTime;
    private final String filePath;

    public CollectionManager(FileManager fileManager) {
        creationTime = OffsetDateTime.now();
        collection = parseXmlFile(fileManager.getFile());
        if (!collection.isAllElementsValid()) {
            collection = new CollectionSpaceMarines();
            System.err.println("Значения в файле не валидны, загруженна пустая коллекция");
        }
        this.filePath = fileManager.getPath();
    }

    /**
     * Метод, реализуюший генерацию уникального id для поля id класса SpaceMarine
     *
     * @return поле id
     */
    public int getFreeRandomId() {
        final int potentialId = new Random().nextInt(Integer.MAX_VALUE);
        if (collection.getMarines().stream().anyMatch(marine -> marine.getId() == potentialId)) {
            return getFreeRandomId();
        } else {
            return potentialId;
        }
    }

    public int getSize() {
        return collection.getMarines().size();
    }

    public OffsetDateTime getCreationTime() {
        return creationTime;
    }

    public CollectionSpaceMarines getCollection() {
        return collection;
    }

    /**
     * Метод, реализующий отчищение коллекции
     */
    public void clear() {
        collection = new CollectionSpaceMarines();
    }

    /**
     * Метод, реализующий сохранение коллекции
     */
    public void save() {
        Parser.saveXmlStringToFile(collection, filePath);
    }
}
