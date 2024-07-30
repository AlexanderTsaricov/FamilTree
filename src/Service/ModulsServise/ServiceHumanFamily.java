package Service.ModulsServise;

import Service.ModulsServise.ModulsService.family.FamilyTree;
import Service.ModulsServise.ModulsService.human.Human;
import Service.ModulsServise.ModulsService.save.Saving;

import java.io.IOException;
import java.util.ArrayList;

public class ServiceHumanFamily {
    FamilyTree<Human> familyTree;
    private static Saving<FamilyTree> saveClass;

    public ServiceHumanFamily() throws IOException, ClassNotFoundException {
        saveClass = new Saving<>();
        this.familyTree = saveClass.load();
    }

    public void save() throws IOException {
        saveClass.save(familyTree);
    }
    public static FamilyTree load() throws IOException, ClassNotFoundException {
        return saveClass.load();
    }
    public Human getOldestHuman() {
        return familyTree.getOldestHuman();
    }
    public Human getYoungestHuman() {
        return familyTree.geYoungestHuman();
    }
    public void addHuman(Human human){
        familyTree.addHuman(human);
    }
    public void setParent(Human parent, Human child) {
        child.setParent(parent);
    }
    public void setParents(Human mather, Human father, Human child) {
        child.setParent(mather, father);
    }
    public void setChild(Human parent, Human child) {
        parent.setChild(child);
    }
    public void setSpouse(Human spouse_1, Human spouse_2){
        spouse_1.setSpouse(spouse_2);
    }
    public ArrayList<Human> getHumansList(){
        return familyTree.getObjList();
    }
    public void sortByName() {
        familyTree.sortByName();
    }
    public void sortByAge() {
        familyTree.sortByAge();
    }

}
