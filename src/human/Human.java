package human;

import java.util.ArrayList;
import java.util.Calendar;

public class Human {
    protected String firstName;
    protected String lastName;
    protected String patronymic;
    protected Calendar dateOfBirth = Calendar.getInstance();
    protected Sex sex;
    Human mather;
    Human father;
    ArrayList<Human> childrens;
    protected boolean alive;
    protected Human spouse;

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

}
