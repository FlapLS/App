package entities;


import managers.IOManager;

import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

/**
 * Класс для описание главы SpaceMarine.
 *
 * @author Базанов Евгений.
 */
public class Chapter {
    @XmlElement
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement
    private long marinesCount; //Значение поля должно быть больше 0, Максимальное значение поля: 1000
    @XmlElement
    private String world; //Поле может быть null

    /**
     * Метод, проверяющий правильность вводимых полей.
     *
     * @return true в случаи правильного ввода всех полей, false в случаи не соблюдений ввода полей.
     */
    public boolean isValuesValid() {
        if (name == null || name.isEmpty()) {
            return false;
        }
        if (marinesCount <= 0 || marinesCount > 1000) {
            return false;
        }
        return true;
    }

    /**
     * Метод, реализующий инициализации объекта Chapter.
     *
     * @param io менеджер ввода-вывода.
     * @return инициализированный объект Chapter.
     */
    public static Chapter initChapter(IOManager io) {
        final Chapter chapter = new Chapter();
        chapter.initName(io);
        chapter.initMarinesCount(io);
        chapter.initWorld(io);
        return chapter;
    }

    /**
     * Метод, реализующий инициализацию поля name класса Chapter
     *
     * @param io менеджер ввода-вывода.
     */
    private void initName(IOManager io) {
        String name = io.requestParameter("name для chapter");
        if (name.isEmpty()) {
            io.getInteractive().println("name не может быть null или пустой строкой");
            initName(io);
            return;
        }
        this.name = name;
    }

    /**
     * Метод,реализующий инициализацию поля marinesCount класса Chapter.
     *
     * @param io менеджер ввода-вывода.
     */
    private void initMarinesCount(IOManager io) {
        String stringCount = io.requestParameter("marinesCount для chapter");
        long count;
        try {
            count = Long.parseLong(stringCount);
            if (count < 0 || count > 1000) {
                io.getInteractive().println("Значение marinesCount должно быть больше 0, Максимальное значение поля: 1000");
                initMarinesCount(io);
                return;
            }
        } catch (NumberFormatException e) {
            io.getInteractive().println("marinesCount долежен быть цельночисленным");
            initMarinesCount(io);
            return;
        }
        this.marinesCount = count;
    }

    /**
     * Метод,реализующий инициализацию поля world класса Chapter.
     *
     * @param io менеджер ввода-вывода.
     */
    private void initWorld(IOManager io) {
        String world = io.requestParameter("world для chapter");
        if (world.isEmpty()) {
            io.getInteractive().println("world не может быть null или пустой строкой");
            initWorld(io);
            return;
        }
        this.world = world;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chapter chapter = (Chapter) o;
        return marinesCount == chapter.marinesCount &&
                name.equals(chapter.name) &&
                world.equals(chapter.world);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, marinesCount, world);
    }


    @Override
    public String toString() {
        return String.format("Chapter{name='%s', marinesCount=%d, world='%s'}", name, marinesCount, world);
    }
}