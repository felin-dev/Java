package _5_StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private final ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(item);
    }

    public String pop() {
        return String.format("%s", this.data.remove(data.size() - 1));
    }

    public String peek() {
        return String.format("%s", this.data.get(data.size() - 1));
    }

    public boolean isEmpty() {
        return this.data.size() == 0;
    }
}
