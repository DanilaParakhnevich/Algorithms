package by.parakhnevich.algorithms.arrayList;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList <E> {

    private Object[] ar;
    private int lastElem = 0;

    public ArrayList() {
        ar = new Object[2];
    }

    public ArrayList(int length) {
        ar = new Object[length];
    }

    public E push(E e) {
        if (lastElem >= ar.length) {
            ar = Arrays.copyOf(ar, ar.length * 2);
        }

        ar[lastElem++] = e;

        return e;
    }

    public E add(E e, int index) {
        if (index < 0 || index >= ar.length ) {
            throw new IndexOutOfBoundsException("Bad index");
        }

        ar[lastElem++] = e;
        return e;
    }

    public E remove(int index) {
        if (index < 0 || index >= ar.length ) {
            throw new IndexOutOfBoundsException("Bad index");
        }

        Object e = ar[index];
        ar[index] = null;
        return (E) e;
    }

    public int size() {
        return ar.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayList<?> arrayList = (ArrayList<?>) o;
        return lastElem == arrayList.lastElem && Arrays.equals(ar, arrayList.ar);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(lastElem);
        result = 31 * result + Arrays.hashCode(ar);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Object e : ar) {
            if (e != null) {
                builder.append(e).append(", ");
            }
        }

        if (builder.length() == 0) {
            return "Empty list";
        }

        return builder.delete(builder.length() - 2, builder.length()).toString();
    }
}
