package family;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class FamilyTree<T extends livingBeing> implements SaveAndLoad, Serializable, Iterable<T> {
    private ArrayList<T> objList;

    public FamilyTree() {
        objList = new ArrayList<>();
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

    public ArrayList<T> getObjList() {
        return objList;
    }

    public void addHuman(T obj) {
        this.objList.add(obj);
    }

    public T geYoungestHuman () {
        T youngestHuman = this.objList.get(0);
        for (int i = 1; i < this.objList.size(); i++) {
            if (this.objList.get(i).getAge() < youngestHuman.getAge()) {
                youngestHuman = this.objList.get(i);
            }
        }
        return youngestHuman;
    }
    public T getOldestHuman () {
        T oldestHuman = this.objList.get(0);
        for (int i = 1; i < this.objList.size(); i++) {
            if (this.objList.get(i).getAge() > oldestHuman.getAge()) {
                oldestHuman = this.objList.get(i);
            }
        }
        return oldestHuman;
    }

    @Override
    public Iterator<T> iterator() {
        return new TreeListIterator(objList);
    }

    public void sortByName() {
        Collections.sort(this.objList, new TreeComparatorName<T>());
    }

    public void sortByAge() {
        Collections.sort(objList, new TreeComparatorAge<T>());
    }
}
