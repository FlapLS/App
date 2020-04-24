package entities;
//TODO DOC

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayDeque;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Класс-хранилище коллекции объектов SpaceMarine
 *
 * @author Базанов Евгений
 */
@XmlRootElement(name = "SpaceMarineCollection")
public class CollectionSpaceMarines {
    @XmlElement(name = "SpaceMarine")
    private ArrayDeque<SpaceMarine> marines = new ArrayDeque<>();

    /**
     * Метод отчищающий колеккцию
     *
     * @return пустую коллекцию
     */
    public static CollectionSpaceMarines emptyCollection() {
        final CollectionSpaceMarines marines = new CollectionSpaceMarines();
        marines.marines = new ArrayDeque<>();
        return marines;
    }


    public ArrayDeque<SpaceMarine> getMarines() {
        return marines.clone();
    }

    /**
     * Метод, необходимый для реализации команд add и add_if_max
     *
     * @param marine
     */
    public void addMarine(SpaceMarine marine) {
        marines.add(marine);
    }

    /**
     * @param predicate
     * @return
     */
    public boolean removeMarineByPredicate(Predicate<SpaceMarine> predicate) {
        return marines.removeIf(predicate);
    }

    /**
     * @return
     */
    public boolean isAllElementsValid() {
        return marines.stream().allMatch(SpaceMarine::isValuesValid);
    }

    /**
     *
     */
    public void sort() {
        marines = marines.stream().sorted().collect(Collectors.toCollection(ArrayDeque::new));
    }


    @Override
    public String toString() {
        if (marines.size() != 0) {
            return String.format("CollectionSpaceMarines{marines=[%n\t%s%n]}",
                    marines.stream().map(SpaceMarine::toString).collect(Collectors.joining(", \n\t")));
        } else {
            return "CollectionSpaceMarines{marines=[]}";
        }
    }
}