package Box;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private final List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (T t : list) {
            output.append(t.getClass()).append(": ").append(t)
                    .append(System.lineSeparator());
        }

        return output.toString().replace("class ", "");
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(this.list, firstIndex, secondIndex);
    }

    public void count(T type) {
        System.out.println(this.list.stream().filter(e -> e.compareTo(type) > 0).count());
    }
}
