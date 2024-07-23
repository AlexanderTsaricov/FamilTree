package family;

import java.io.*;

public interface SaveAndLoad {
    abstract void save() throws IOException;
    abstract FamilyTree load() throws IOException, ClassNotFoundException;
}
