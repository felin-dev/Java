package _4_Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private final List<Integer> jumps;

    public Lake(List<Integer> jumps) {
        this.jumps = jumps;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index >= 0 && this.index < jumps.size();
            }

            @Override
            public Integer next() {
                if (this.index % 2 == 0) {
                    int tempIndex = this.index;
                    this.index += 2;
                    if (index >= jumps.size()) {
                        index = 1;
                    }
                    return jumps.get(tempIndex);
                } else {
                    int tempIndex = this.index;
                    this.index += 2;
                    return jumps.get(tempIndex);
                }
            }
        };
    }
}
