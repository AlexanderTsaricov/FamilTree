package family;

import human.Human;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class TreeListIterator implements Iterator<Human> {
    private ArrayList<Human> humanList;
    private int index;
    public TreeListIterator (ArrayList<Human> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        if (humanList.size() > index) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }
}
