package CustomList;

import java.util.Comparator;

public class Sorter<CustomList extends Comparable<CustomList>> implements Comparator<CustomList> {

    @Override
    public int compare(CustomList o1, CustomList o2) {
        return o1.compareTo(o2);
    }
}
