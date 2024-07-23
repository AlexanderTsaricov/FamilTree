import human.Human;

import java.io.*;
import java.util.ArrayList;

public interface SaveAndLoad {
    abstract void save() throws IOException;
    abstract FamilyTree load() throws IOException, ClassNotFoundException;
}
