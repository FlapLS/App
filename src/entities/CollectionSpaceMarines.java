package entities;
//TODO DOC

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayDeque;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Класс-хранилище коллекции объектов SpaceMarine.
 *
 * @author Базанов Евгений.
 */
@XmlRootElement(name = "SpaceMarineCollection")
public class CollectionSpaceMarines {
    @XmlElement(name = "SpaceMarine")
    private ArrayDeque<SpaceMarine> marines = new ArrayDeque<>();

    /**
     * Геттер, возвращающий копию массива элементов.
     */
    public ArrayDeque<SpaceMarine> getMarines() {
        return marines.clone();
    }

    /**
     * Метод для добавления элемента в коллекцию.
     *
     * @param marine объект который будет добавлен в коллекцию.
     */
    public void addMarine(SpaceMarine marine) {
        marines.add(marine);
    }

    /**
     * Метод использующий фильтр(предикат) для удаление объектов SpaceMarine"
     *
     * @param predicate фильтр-предикат, возвращающий значение true для удаляемых элементов типа SpaceMarine
     * @return возвращает true,если какие-либо элементы были удалены, false нет
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
     * Метод, реализовывающий сортировку по возрастанию.
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