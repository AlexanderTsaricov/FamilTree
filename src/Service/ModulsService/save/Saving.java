package Service.ModulsService.save;

import Service.ModulsService.family.LivingBeing;
import Service.ModulsService.family.SaveAndLoad;
import Service.ModulsService.family.Tree;

import java.io.*;

public class Saving<F extends Tree<H, F>, H extends LivingBeing<H>> implements SaveAndLoad<H, F> {
    @Override
    public void save(F obj) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("src/Service/ModulsService/save/save.json"));
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();

    }

    @Override
    public F load() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("src/Service/ModulsService/save/save.json"));
        F loadObj = (F) objectInputStream.readObject();
        objectInputStream.close();
        return loadObj;
    }
}
