package human;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import family.LivingBeing;

public class Human implements Serializable, Comparable<Human>, LivingBeing {
    private String firstName;
    private String lastName;
    private String patronymic;
    private Calendar dateOfBirth = Calendar.getInstance();
    private Sex sex;
    Human mather;
    Human father;
    ArrayList<Human> childrens;
    private boolean alive;
    private Human spouse;

    public Human(String firstName, String lastName, String patronymic, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.sex = sex;
        childrens = new ArrayList<>();
    }
    public Human(String firstName, String lastName, String patronymic, Sex sex, boolean alive) {
        this(firstName, lastName, patronymic, sex);
        this.alive = alive;
    }

    public Human(String firstName, String lastName, String patronymic, Sex sex, boolean alive, Calendar dateOfBirth) {
        this(firstName, lastName, patronymic, sex, alive);
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return String.format("%s, %s %s %s, %s year of birth", sex, lastName, firstName, patronymic, dateOfBirth.get(Calendar.YEAR));
    }

    public void setBirthDay (int year, int month, int day) {
        dateOfBirth.set(year, month, day);
    }

    public int getAge() {
        Calendar date = Calendar.getInstance();
        int calYear = date.get(Calendar.YEAR);
        int calMonth = date.get(Calendar.MONTH);
        int calDay = date.get(Calendar.DAY_OF_MONTH);
        int birthYear = this.dateOfBirth.get(Calendar.YEAR);
        int birthMonth = this.dateOfBirth.get(Calendar.MONTH);
        int birthDay = this.dateOfBirth.get(Calendar.DAY_OF_MONTH);
        int age = calYear - birthYear;
        if ((calMonth < birthMonth)) {
            if (calDay < birthDay) {
                age -= 1;
            }
        }
        return age;
    }
    public ArrayList<Human> getParents(){
        ArrayList<Human> parents = new ArrayList<>();
        parents.add(this.father);
        parents.add(this.mather);
        return parents;
    }
    public Human getMather(){
        return this.mather;
    }
    public Human getFather(){
        return this.father;
    }

    public Human getSpouse(){
        return this.spouse;
    }
    public ArrayList<Human> getChildrens() {
        return childrens;
    }

    /**
     * @param parent - Родитель
     * @param child - Ребенок (человек для которого добавляется родитель)
     * */
    public static void setParent(Human parent, Human child) {
        Sex sex = parent.sex;
        if (Sex.Female == sex) {
            child.mather = parent;
        } else {
            child.father = parent;
        }
    }
    /**
     * @param mather - Мать
     * @param father - Отец
     * @param child - Ребенок (человек для которого добавляется родитель)
     * */
    public static void setParent(Human mather, Human father, Human child) {
        child.mather = mather;
        child.father = father;
        setChild(mather, child);
        setChild(father, child);
    }

    /**
     * @param parent - Родитель (человек для которого добавляется ребенок)
     * @param child - Ребенок
     * */
    public static void setChild(Human parent, Human child) {
        parent.childrens.add(child);
        setParent(parent, child);
    }
    public static void setSpouse(Human spouse_1, Human spouse_2){
        spouse_1.spouse = spouse_2;
        spouse_2.spouse = spouse_1;
    }

    @Override
    public int compareTo(Human o) {
        String name = this.lastName + this.firstName + this.patronymic;
        String nameO = o.lastName + o.firstName + this.patronymic;
        return name.compareTo(nameO);
    }

    @Override
    public String getName() {
        return this.lastName + this.firstName + this.patronymic;
    }
}


