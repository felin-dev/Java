package _1_ListyIterator;

import java.util.List;
import java.util.StringJoiner;

public class ListyIterator {
    private final List<String> list;
    private int index;

    public ListyIterator(List<String> elements) {
        this.list = elements;
        if (!elements.isEmpty()) {
            this.index = 0;
        } else {
            this.index = -1;
        }
    }

    public boolean move() {
        if (index + 1 < list.size()) {
            index++;
            return true;
        }

        return false;
    }

    public void print() {
        if (!list.isEmpty()) {
            System.out.println(this.list.get(this.index));
        } else {
            System.out.println("Invalid Operation!");
        }
    }

    public boolean hasNext() {
        return index + 1 < list.size();
    }

    @Override
    public String toString() {
        StringJoiner output = new StringJoiner(" ");
        this.list.forEach(output::add);
        return output.toString();
    }
}