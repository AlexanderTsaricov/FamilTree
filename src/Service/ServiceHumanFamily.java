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
    private String ERROR = "";
    public ServiceHumanFamily() throws IOException, ClassNotFoundException {
        Saving<FamilyTree<Human>, Human> save = new Saving<>();
        try {
            this.familyTree = save.load();
        } catch (IOException e){
            ERROR = e.getMessage() + " - Не получилось загрузить семью";
            this.familyTree = new FamilyTree<>();
        } catch (ClassNotFoundException e) {
            this.familyTree = new FamilyTree<>();
            System.out.println(e.getMessage());
        }

    }
    public String getError() {
        return this.ERROR;
    }
    /**
     * Save the family tree
     * */
    public void save() throws IOException {
        Saving<FamilyTree<Human>, Human> save = new Saving<>();
        save.save(familyTree);
    }
    /**
     * Download the family tree
     * */
    public FamilyTree load() throws IOException, ClassNotFoundException {
        Saving<FamilyTree<Human>, Human> save = new Saving<>();
        return save.load();
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
     * @param human the new person who added to the family tree
     * */
    public void addHuman(Human human){
        familyTree.addHuman(human);
    }
    /**
     * Add parent from human
     * @param child the person for whom to add the parent
     * @param parent the parent for whom to add the child
     * */
    public void setParent(Human child, Human parent) {
        child.setParent(parent);
    }
    /**
     * Add parents from human
     * */
    public void setParents(Human mather, Human father, Human child) {
        child.setParent(mather, father);
    }
    /**
     * Add children from human
     * @param parent the person for whom to add the children
     * @param child the person the son of the parent
     * */
    public void setChild(Human parent, Human child) {
        parent.setChild(child);
    }
    /**
     * Add spourse from human
     * */
    public void setSpouse(Human human, Human spouse){
        human.setSpouse(spouse);
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
    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }

}
