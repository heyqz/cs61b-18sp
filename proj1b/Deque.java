/** This interface defines the methods for ArrayDeque and LinkedListDeque. */
public interface Deque<T> {
    void addFirst(T x);
    void addLast(T x);
    boolean isEmpty();
    int size();
    void printDeque();
    T removeFirst();
    T removeLast();
    T get(int index);
}
