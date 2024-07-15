package human;

public class BloodLine {
    public void setParent(Human parent, Human child) {
        Sex sex = parent.sex;
        if (Sex.Female == sex) {
            child.mather = parent;
        } else {
            child.father = parent;
        }
    }
    public void setParent(Human mather, Human father, Human child) {
        child.mather = mather;
        child.father = father;
    }
    public void setChild(Human parent, Human child) {
        parent.childrens.add(child);
    }
}
