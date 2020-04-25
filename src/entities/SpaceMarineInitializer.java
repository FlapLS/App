package entities;

import managers.IOManager;

import java.time.LocalDate;

/**
 * Класс служит для инициализации объекта SpaceMarine с помощью средств ввода-вывода.
 *
 * @author Базанов Евгений.
 */
public class SpaceMarineInitializer {
    private SpaceMarine marine = new SpaceMarine();
    private IOManager io;

    public SpaceMarineInitializer(IOManager ioManager, int id) {
        this.io = ioManager;
        marine.setId(id);
        marine.setCreationDate(LocalDate.now());
    }

    /**
     * Метод, реализующий инициализацию полей класса SpaceMarine.
     *
     * @return инициализированные поля класса SpaceMarine.
     */
    public SpaceMarine initialize() {
        marine.setName(initName());
        marine.setCoordinates(Coordinates.initCoordinates(io));
        marine.setHealth(initHealth());
        marine.setAchievements(initAchievements());
        marine.setHeight(initHeight());
        marine.setCategory(initCategory());
        marine.setChapter(Chapter.initChapter(io));
        return marine;
    }

    /**
     * Метод, реализующий инициализацию поля name класса SpaceMarine.
     *
     * @return поле name.
     */
    private String initName() {
        String name = io.requestParameter("name");
        if (name.isEmpty()) {
            io.getInteractive().println("name не может быть null или пустой строкой");
            return initName();
        }
        return name;
    }

    /**
     * Метод, реализующий инициализацию поля health класса SpaceMarine.
     *
     * @return поле health.
     */
    private float initHealth() {
        String healthString = io.requestParameter("health");
        try {
            float health = Float.parseFloat(healthString);
            if (health < 0) {
                io.getInteractive().println("health должен быть больше нуля");
                return initHealth();
            } else {
                return health;
            }
        } catch (NumberFormatException e) {
            io.getInteractive().println("health должен быть типом с плавающей точкой");
            return initHealth();
        }
    }

    /**
     * Метод, реализующий инициализацию поля achievements класса SpaceMarine.
     *
     * @return поле achievement.
     */
    private String initAchievements() {
        String achievements = io.requestParameter("achievements");
        if (achievements.isEmpty()) {
            io.getInteractive().println("achievements не может быть null или пустой строкой");
            return initAchievements();
        }
        return achievements;
    }

    /**
     * Метод, реализующий инициализацию поля height класса SpaceMarine.
     *
     * @return поле height.
     */
    private long initHeight() {
        final String height = io.requestParameter("height");
        try {
            return Long.parseLong(height);
        } catch (NumberFormatException e) {
            io.getInteractive().println("height долежен быть цельночисленным");
            return initHeight();
        }
    }

    /**
     * Метод, реализующий инициализацию поля category класса SpaceMarine.
     *
     * @return поле category.
     */
    private AstartesCategory initCategory() {
        final String categoryString = io.requestParameter(
                "category (возможные значения: DREADNOUGHT, AGGRESSOR, ASSAULT, TERMINATOR, LIBRARIAN)");
        try {
            return AstartesCategory.valueOf(categoryString);
        } catch (IllegalArgumentException e) {
            io.getInteractive().println("значение введено в неправильном формате");
            return initCategory();
        }
    }
}