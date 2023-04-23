public class FIFO<E> implements IQueue<E> {

     OneWayLinkedList<E> lista;
    public FIFO() {
        lista = new OneWayLinkedList<>();
    }
    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }
    @Override
    public E dequeue() throws Exception {
        E value= lista.remove(0);
        if(value==null) throw new Exception();
        return value;
    }
    @Override
    public void enqueue(E elem) { lista.add(elem); }
    @Override
    public int size() { return lista.size(); }
    @Override
    public E first() throws Exception {
        E value= lista.get(0);
        if(value==null) throw new Exception();
        return value;
    }
}
