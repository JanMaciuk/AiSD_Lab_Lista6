
public class OneWayLinkedListWithHead<E>{
    private class Element{

        private E value;
        private Element next;

        public E getValue() {
            return value;
        }

        public void setValue(E value) { this.value = value; }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        Element(E data){
            this.value=data;
        }
    }

    Element head=null;

    public OneWayLinkedListWithHead(){}

    public boolean isEmpty(){
        return head==null;
    }

     
    public void clear() {
        head=null;
    }

     
    public int size() {
        int pos=0;
        Element actElem=head;
        while(actElem!=null)
        {
            pos++;
            actElem=actElem.getNext();
        }
        return pos;
    }

    private Element getElement(int index){
        Element actElem=head;
        while(index>0 && actElem!=null){
            index--;
            actElem=actElem.getNext();
        }
        return actElem;
    }

     
    public boolean add(E e) {
        Element newElem=new Element(e);
        if(head==null){
            head=newElem;
            return true;
        }
        Element tail=head;
        while(tail.getNext()!=null)
            tail=tail.getNext();
        tail.setNext(newElem);
        return true;
    }
     
    public E get(int index) {
        Element actElem=getElement(index);
        return actElem==null?null:actElem.getValue();
    }


    public E remove(int index) {
        if(head==null)
            return null;
        if(index==0){
            E retValue=head.getValue();
            head=head.getNext();
            return retValue;
        }
        Element actElem=getElement(index-1);
        if(actElem==null || actElem.getNext()==null)
            return null;
        E retValue=actElem.getNext().getValue();
        actElem.setNext(actElem.getNext().getNext());
        return retValue;
    }


}
