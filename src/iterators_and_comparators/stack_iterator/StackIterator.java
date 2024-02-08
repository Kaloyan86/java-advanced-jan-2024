package iterators_and_comparators.stack_iterator;

import java.util.Iterator;

public class StackIterator implements Iterable<Integer> {

    private Integer[] elements;
    private int internalIndex;

    public StackIterator() {
        this.elements = new Integer[16];
        this.internalIndex = 0;
    }

    public void push(int element) {
        this.elements[this.internalIndex++] = element;
    }

    public Integer pop() {
        if (this.internalIndex == 0) {
            throw new IllegalStateException("No elements");
        }

        // Премахваме винаги последния елемент
        Integer element = this.elements[this.internalIndex - 1];
        // Зачистваме елемента от масива
        this.elements[this.internalIndex - 1] = null;
        // Намаляваме internalIndex с 1
        this.internalIndex--;

        return element;
    }

    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {

            int index = internalIndex - 1;

            @Override
            public boolean hasNext() {
                return this.index >= 0;
            }

            @Override
            public Integer next() {
                return elements[this.index--];
            }
        };
    }
}
