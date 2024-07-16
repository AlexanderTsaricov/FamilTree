package human;

public class BloodLine {
    public void setParent(Human parent, Human child) {
        /**
         * @param parent - Родитель
         * @param child - Ребенок (человек для которого добавляется родитель)
         * */
        Sex sex = parent.sex;
        if (Sex.Female == sex) {
            child.mather = parent;
        } else {
            child.father = parent;
        }
    }
    public void setParent(Human mather, Human father, Human child) {
        /**
         * @param mather - Мать
         * @param father - Отец
         * @param child - Ребенок (человек для которого добавляется родитель)
         * */
        child.mather = mather;
        child.father = father;
        setChild(mather, child);
        setChild(father, child);
    }
    public void setChild(Human parent, Human child) {
        /**
         * @param parent - Родитель (человек для которого добавляется ребенок)
         * @param child - Ребенок
         * */
        parent.childrens.add(child);
        setParent(parent, child);
    }
    public void setSpouse(Human spouse_1, Human spouse_2){
        spouse_1.spouse = spouse_2;
        spouse_2.spouse = spouse_1;
    }
}
