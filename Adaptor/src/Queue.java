import java.util.ArrayList;

public class Queue implements StringQueue {

    private final int cap;
    private ArrayList<String> list;

    public Queue(int cap) {
        this.cap = cap;
        list = new ArrayList<>();
    }

    @Override
    public void enqueue(String element) {
        if (list.size()>=cap) throw new IndexOutOfBoundsException("List cap reached");
        if (element == null) throw new IllegalArgumentException("Cannot add null to the queue");
        list.add(element);

    }

    @Override
    public String dequeue() {
        if (list.isEmpty()) throw new IllegalArgumentException("The list is empty");
        return list.remove(0);
    }

    @Override
    public String first() {
        if (list.isEmpty()) throw new IllegalArgumentException("The list is empty");
        return list.get(0);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int indexOf(String element) {
        return list.indexOf(element);
    }

    @Override
    public boolean contains(String element) {
        return list.contains(element);
    }

    @Override
    public String toString() {
        String temp = "{";
        for (String i : list
        ) {
            temp+=i+",";
        }
        temp+= "}";
        return temp;
    }
}
