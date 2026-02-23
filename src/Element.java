public class Element<T> {
    private T wert;
    private Element<T> next;

    public Element(T wert, Element<T> next){
        this.wert = wert;
        this.next = next;
    }

    public T getWert() {

        
        return wert;
    }

    public void setWert(T wert) {
        this.wert = wert;
    }

    public Element<T> getNext() {
        return next;
    }

    public void setNext(Element<T> next) {
        this.next = next;
    }
}
