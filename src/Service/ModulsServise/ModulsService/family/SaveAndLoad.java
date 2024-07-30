package Service.ModulsServise.ModulsService.family;

import java.io.*;

public interface SaveAndLoad<T> {
    abstract void save(T obj) throws IOException;
    abstract T load() throws IOException, ClassNotFoundException;
}
