package vector;
public interface SimpleList<T> {
    public int size();

    public void clear();

    public void insertAtTail(T element);

    public void insertAtHead(T element);

    public void insertAt(int index,T element);

    public T removeAtTail();
    public T removeAtHead();
    public T removeAt(int index);

    public T get(int index);

    public int find(T element);


}
