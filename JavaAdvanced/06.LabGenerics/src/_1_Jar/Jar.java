package _1_Jar;

import java.util.ArrayDeque;

public class Jar<T> {
    private final ArrayDeque<T> elements;

    public Jar() {
        this.elements = new ArrayDeque<>();
    }

    public void add(T element) {
        this.elements.push(element);
    }

    public T remove() {
        return this.elements.pop();
    }

    @Override
    public String toString() {
        return "Jar{" +
                "elements=" + elements +
                '}';
    }
}