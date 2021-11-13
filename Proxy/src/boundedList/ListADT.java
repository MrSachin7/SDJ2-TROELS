package boundedList;

public interface ListADT {
    void add(String s);
    void add(int idx, String s);
    String get(int index);
    String remove(int index);
    String remove(String s);
    boolean contains(String s);
    boolean isEmpty();
    int size();
}
