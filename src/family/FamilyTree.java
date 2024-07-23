package family;

import human.Human;
import human.HumanComparatorAge;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class FamilyTree implements SaveAndLoad, Serializable, Iterable<Human> {
    private ArrayList<Human> humanList;

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    public void save() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("humans.json"));
        objectOutputStream.writeObject(this);
        objectOutputStream.close();

    }
    public FamilyTree load() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("humans.json"));
        FamilyTree familyTree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return familyTree;
    }

    public ArrayList<Human> getHumanList() {
        return humanList;
    }

    public void addHuman(Human human) {
        this.humanList.add(human);
    }

    public Human geYoungestHuman () {
        Human youngestHuman = this.humanList.get(0);
        for (int i = 1; i < this.humanList.size(); i++) {
            if (this.humanList.get(i).getAge() < youngestHuman.getAge()) {
                youngestHuman = this.humanList.get(i);
            }
        }
        return youngestHuman;
    }
    public Human getOldestHuman () {
        Human oldestHuman = this.humanList.get(0);
        for (int i = 1; i < this.humanList.size(); i++) {
            if (this.humanList.get(i).getAge() > oldestHuman.getAge()) {
                oldestHuman = this.humanList.get(i);
            }
        }
        return oldestHuman;
    }

    @Override
    public Iterator<Human> iterator() {
        return new TreeListIterator(humanList);
    }

    public void sortByName() {
        Collections.sort(humanList);
    }

    public void sortByAge() {
        Collections.sort(humanList, new HumanComparatorAge());
    }
}
