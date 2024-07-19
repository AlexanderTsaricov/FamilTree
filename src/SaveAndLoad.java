import human.Human;

import java.io.*;
import java.util.ArrayList;

public class SaveAndLoad implements Serializable {

    public SaveAndLoad() throws IOException {
    }
    public void save(ArrayList<Human> family) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("humans.json"));
        objectOutputStream.writeObject(family);

    }
    public ArrayList<Human> load() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("humans.json"));
            return (ArrayList) objectInputStream.readObject();
    }
}
