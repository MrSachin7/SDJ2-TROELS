package boundedList;

import java.util.ArrayList;

public class MyArrayList implements ListADT {

    private ArrayList<String> arrayList;
    private int maxSize;

    public MyArrayList(int maxSize) {
        this.maxSize = maxSize;
        arrayList = new ArrayList<>();
    }

    @Override
    public void add(String s) {
        if (maxSize >= arrayList.size()) {
            throw new IndexOutOfBoundsException("Maximum size reached");
        } else {
            arrayList.add(s);
        }
    }

    @Override
    public void add(int idx, String s) {
        if (maxSize >= arrayList.size()) {
            throw new IndexOutOfBoundsException("Maximum size reached");
        } else {
            arrayList.add(idx, s);
        }
    }

    @Override
    public String get(int index) {
        if (maxSize >= arrayList.size()) {
            throw new IndexOutOfBoundsException("Maximum size reached");
        } else {
            return arrayList.get(index);
        }
    }

    @Override
    public String remove(int index) {
        if (maxSize >= arrayList.size()) {
            throw new IndexOutOfBoundsException("Maximum size reached");
        } else {
            return arrayList.remove(index);
        }
    }

    @Override
    public String remove(String s) {
        if (maxSize >= arrayList.size()) {
            throw new IndexOutOfBoundsException("Maximum size reached");
        } else {
            if (arrayList.remove(s)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public boolean contains(String s) {
        if (maxSize >= arrayList.size()) {
            throw new IndexOutOfBoundsException("Maximum size reached");
        } else {
            return arrayList.contains(s);
        }
    }

    @Override
    public boolean isEmpty() {
        if (maxSize >= arrayList.size()) {
            throw new IndexOutOfBoundsException("Maximum size reached");
        } else {
          return   arrayList.isEmpty();
        }
    }

    @Override
    public int size() {
        return arrayList.size();
    }
}
