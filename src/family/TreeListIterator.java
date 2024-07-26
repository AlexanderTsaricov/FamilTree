package family;

import java.util.ArrayList;
import java.util.Iterator;

public class TreeListIterator<T> implements Iterator<T> {
    private ArrayList<T> objList;
    private int index;
    public TreeListIterator (ArrayList<T> objList) {
        this.objList = objList;
    }

    @Override
    public boolean hasNext() {
        if (objList.size() > index) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T next() {
        return objList.get(index++);
    }
}
