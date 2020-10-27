package _2_ListyIterator;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
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
        if (this.index + 1 < this.list.size()) {
            this.index++;
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
        return this.index + 1 < this.list.size();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index >= 0 && index < list.size();
            }

            @Override
            public String next() {
                return list.get(this.index++);
            }
        };
    }
}