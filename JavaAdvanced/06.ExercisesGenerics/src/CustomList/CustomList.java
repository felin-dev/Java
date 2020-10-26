package CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private final List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public void remove(int index) {
        validateIndex(index);
        this.list.remove(index);
    }

    public boolean contains(T element) {
        return this.list.contains(element);
    }

    public void swap(int indexOne, int indexTwo) {
        validateIndex(indexOne);
        validateIndex(indexTwo);
        Collections.swap(this.list, indexOne, indexTwo);
    }

    public void sort() {
        this.list.sort(new Sorter<T>());
    }

    public int countGreaterThan(T element) {
            return (int) this.list.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        if (this.list.isEmpty()) {
            throw new IllegalArgumentException("Empty list!");
        } T max = this.list.get(0);
        for (int i = 1; i < this.list.size(); i++) {
            if (max.compareTo(this.list.get(i)) < 0){
                max = this.list.get(i);
            }
        }
        return max;
    }

    public T getMin() {
        if (this.list.isEmpty()) {
            throw new IllegalStateException("Empty list!");
        } T min = this.list.get(0);
        for (int i = 1; i < this.list.size(); i++) {
            if (min.compareTo(this.list.get(i)) > 0){
                min = this.list.get(i);
            }
        }
        return min;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= this.list.size()) {
            throw new IndexOutOfBoundsException("Index is invalid!");
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (T t : list) {
            output.append(t).append(System.lineSeparator());
        }

        return output.toString();
    }
}
