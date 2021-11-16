
public interface StringQueue {

	public void enqueue(String element);
	public String dequeue();
	public String first();
	public int size();
	public boolean isEmpty();
	public int indexOf(String element);
	public boolean contains(String element);
}
