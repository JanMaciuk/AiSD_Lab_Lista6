public interface IQueue<T> {
    boolean isEmpty();
    T dequeue() throws Exception;
    void enqueue(T elem) throws Exception;
    int size();
    T first() throws Exception;
}