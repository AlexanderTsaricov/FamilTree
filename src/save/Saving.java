package save;

import family.FamilyTree;
import family.LivingBeing;
import family.SaveAndLoad;

import java.io.*;

public class Saving<T> implements SaveAndLoad<T> {
    @Override
    public void save(T obj) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("src/save/save.json"));
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();

    }

    @Override
    public T load() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("src/save/save.json"));
        T loadObj = (T) objectInputStream.readObject();
        objectInputStream.close();
        return loadObj;
    }
}
