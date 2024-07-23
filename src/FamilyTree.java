import human.Human;
import human.Sex;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class FamilyTree implements SaveAndLoad, Serializable {
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
}
