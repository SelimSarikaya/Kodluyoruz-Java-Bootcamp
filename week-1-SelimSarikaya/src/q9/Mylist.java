package q9;

import java.util.Arrays;

public class Mylist<E> {
	
    private int size = 0;

    private static final int DEFAULT_CAPACITY = 5;

    private String elements[];

    public Mylist() {
        elements = new String[DEFAULT_CAPACITY];
    }

    public void add(String e) {
        while (e.startsWith("C")) {
            if (size == elements.length) {
                ensureCapacity();

            }
            elements[size++] = e;
            break;

        }
    }

    public int newsize() {
        return newSize;
    }

    public int size() {
        return size;
    }

    int newSize;

    private void ensureCapacity() {
        newSize = elements.length + 7;
        elements = Arrays.copyOf(elements, newSize);
    }

    public String toString() { // print
        StringBuilder prn = new StringBuilder();
        for (int i = 0; i < size; i++) {
            prn.append(elements[i]);
            if (i < size - 1) {
                prn.append(",");
            }
        }

        return prn.toString();
    }
}


