package entities;
//TODO ДОДЕЛАТЬ JOC

import managers.IOManager;

import javax.xml.bind.annotation.XmlElement;

/**
 * Класс с координатами SpaceMarine.
 *
 * @author Базанов Евгений.
 */
public class Coordinates {
    @XmlElement
    private Integer x; //Поле не может быть null
    @XmlElement
    private Long y; //Максимальное значение поля: 72, Поле не может быть null

    /**
     * Метод, реализующий инициализацию полей класса Coordinates.
     *
     * @param ioManager //TODO менеджер ввода-вывода.
     * @return инициализированные поля класса Coordinates.
     */
    public static Coordinates initCoordinates(IOManager ioManager) {
        final Coordinates coordinates = new Coordinates();
        coordinates.initCoordinateX(ioManager);
        coordinates.initCoordinateY(ioManager);
        return coordinates;
    }

    /**
     * *Метод, реализующий инициализацию поля x класса Coordinates.
     *
     * @param io менеджер ввода-вывода.
     */
    private void initCoordinateX(IOManager io) {
        final String coordinate = io.requestParameter("coordinates.x");
        try {
            this.x = Integer.parseInt(coordinate);
        } catch (NumberFormatException e) {
            io.getInteractive().println("coordinates.x должен быть цельночисленным");
            initCoordinateX(io);
        }
    }

    /**
     * Метод, реализующий инициализацию поля y класса Coordinates.
     *
     * @param io менеджер ввода-вывода.
     */
    private void initCoordinateY(IOManager io) {
        final String coordinate = io.requestParameter("coordinates.y");
        try {
            long y = Long.parseLong(coordinate);
            if (y >= 72) {
                io.getInteractive().println("Максимальное значение coordinates.y - 72");
                initCoordinateY(io);
                return;
            }
            this.y = y;
        } catch (NumberFormatException e) {
            io.getInteractive().println("coordinates.y долежен быть цельночисленным");
            initCoordinateY(io);
        }
    }

    /**
     * Метод, проверяющий правильность вводимых полей
     *
     * @return true в случаи правильного ввода всех полей, false в случаи не соблюдений ввода полей
     */
    public boolean isValuesValid() {
        if (x == null) {
            return false;
        }
        if (y == null || y >= 72) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return String.format("Coordinates{x=%d, y=%d}", x, y);
    }
}