package Service.ModulsService.human;

import java.util.Comparator;

public class HumanComparatorAge implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getAge() - o2.getAge();
    }
}
