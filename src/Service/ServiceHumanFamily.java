package Service;

import Service.ModulsService.family.FamilyTree;
import Service.ModulsService.human.Human;
import Service.ModulsService.human.Sex;
import Service.ModulsService.save.Saving;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class ServiceHumanFamily {
    FamilyTree<Human> familyTree;
    public Human human;
    public Human humanFromFamily;
    public Sex useSex;
    public Sex male = Sex.Male;
    public Sex female = Sex.Female;
    private static Saving<FamilyTree<Human>, Human> saveClass;
    public String ERROR = "";

    public ServiceHumanFamily() throws IOException, ClassNotFoundException {
        saveClass = new Saving<>();
        human = new Human("NoName", "NoName", "NoName", Sex.Male);
        humanFromFamily = new Human("NoName", "NoName", "NoName", Sex.Male);
        try {
            ERROR = "Успешная загрузка семьи";
            this.familyTree = saveClass.load();
        } catch (IOException e){
            ERROR = e.getMessage() + " - Не получилось загрузить семью";
            this.familyTree = new FamilyTree<>();
        } catch (ClassNotFoundException e) {
            this.familyTree = new FamilyTree<>();
            System.out.println(e.getMessage());
        }

    }
    public void newHuman(String firstName, String lastName, String patronimyc, boolean alive, Calendar dateOfBirth){
        this.human = new Human(firstName, lastName, patronimyc, this.useSex, alive, dateOfBirth);
    }
    /**
     * Save the family tree
     * */
    public void save() throws IOException {
        saveClass.save(familyTree);
    }
    /**
     * Download the family tree
     * */
    public static FamilyTree load() throws IOException, ClassNotFoundException {

        return saveClass.load();
    }
    /**
     * Return oldest human from the family tree
     * */
    public Human getOldestHuman() {
        if (familyTree.getObjList().size() > 0) {
            return familyTree.getOldestHuman();
        } else {
            ERROR = "Династия пуста";
            return null;
        }
    }
    /**
     * Return youngest human from the family tree
     * */
    public Human getYoungestHuman() {
        if (familyTree.getObjList().size() > 0) {
            return familyTree.geYoungestHuman();
        } else {
            ERROR = "Династия пуста";
            return null;
        }

    }
    /**
     * Add new human in family tree
     * */
    public void addHuman(){
        familyTree.addHuman(this.human);
    }
    /**
     * Add parent from human
     * */
    public void setParent() {
        this.human.setParent(this.humanFromFamily);
    }
    /**
     * Add parents from human
     * */
    public void setParents(Human mather, Human father, Human child) {
        child.setParent(mather, father);
    }
    /**
     * Add children from human
     * */
    public void setChild() {
        this.human.setChild(this.humanFromFamily);
    }
    /**
     * Add spourse from human
     * */
    public void setSpouse(){
        this.human.setSpouse(this.humanFromFamily);
    }
    /**
     * Return list of humans from family tree
     * */
    public ArrayList<Human> getHumansList(){
        return familyTree.getObjList();
    }
    /**
     * Sorting list in family tree by name
     * */
    public void sortByName() {
        familyTree.sortByName();
    }
    /**
     * Sorting list in family tree by age
     * */
    public void sortByAge() {
        familyTree.sortByAge();
    }

}
