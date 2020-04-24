package entities;

import utils.LocalDateAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

/**
 * Класс SpaceMarine, объектами которого заполняется коллекция
 *
 * @author Базанов Евгений
 */
@XmlRootElement(name = "SpaceMarine")
@XmlType(propOrder = {"id", "name", "creationDate", "coordinates", "health", "achievements", "height", "category", "chapter"})
public class SpaceMarine implements Comparable<SpaceMarine> {
    @XmlElement
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @XmlElement
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement
    private Coordinates coordinates; //Поле не может быть null
    @XmlElement
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @XmlElement
    private float health; //Значение поля должно быть больше 0
    @XmlElement
    private String achievements; //Поле не может быть null
    @XmlElement
    private Long height; //Поле не может быть null
    @XmlElement
    private AstartesCategory category; //Поле не может быть null
    @XmlElement
    private Chapter chapter; //Поле не может быть null

    public SpaceMarine() {
    }

    public Integer getId() {
        return id;
    }

    void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public float getHealth() {
        return health;
    }

    void setHealth(float health) {
        this.health = health;
    }

    public String getAchievements() {
        return achievements;
    }

    void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public Long getHeight() {
        return height;
    }

    void setHeight(Long height) {
        this.height = height;
    }

    public AstartesCategory getCategory() {
        return category;
    }

    void setCategory(AstartesCategory category) {
        this.category = category;
    }

    public Chapter getChapter() {
        return chapter;
    }

    void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    /**
     * метод ,проверяющий правильность вводимых полей
     *
     * @return true в случаи правильного ввода всех полей ,false в случаи не соблюдений ввода полей
     */
    public boolean isValuesValid() {
        if (id == null) {
            return false;
        }
        if (name == null) {
            return false;
        }
        if (coordinates == null || !coordinates.isValuesValid()) {
            return false;
        }
        if (creationDate == null) {
            return false;
        }
        if (health < 0) {
            return false;
        }
        if (achievements == null) {
            return false;
        }
        if (height == null) {
            return false;
        }
        if (category == null) {
            return false;
        }
        if (chapter == null || !chapter.isValuesValid()) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(SpaceMarine o) {
        return this.id - o.id;
    }

    @Override
    public String toString() {
        return "SpaceMarine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", health=" + health +
                ", achievements='" + achievements + '\'' +
                ", height=" + height +
                ", category=" + category +
                ", chapter=" + chapter +
                '}';
    }
}