import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
//jg
public class Liste<T> implements List{
    private Element<T> kopf;

    public Liste(T wert){
        this.kopf = new Element<>(wert, null); 
    }

    public Element<T> getKopf() {
        return kopf;
    }

    public void setKopf(Element<T> kopf) {
        this.kopf = kopf;
    }

    @Override
    public int size() {      
        int size = 0;
        Element<T> k = this.getKopf();

        while (k != null) {
            size++;
            k = k.getNext();
        }
        return size;
        //throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public boolean isEmpty() {
        return kopf == null;
        //throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public boolean contains(Object o) {
        Element<T> k = this.getKopf();

        while (k != null) {
            if (o.equals(k.getWert())) {
                return true;
            }
            k = k.getNext();
        }
        return false;
       //throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public Object[] toArray(Object[] a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public boolean add(Object e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public boolean remove(Object o) {
         if (!contains(o)) {
            return false;
        }
        
        Element<T> k = this.getKopf();

        if (o.equals(k.getWert())) {
            if (size() > 1) {
                setKopf(k.getNext());
            } else {
                setKopf(null);
            }
            return true;
        }
        
        Element<T> elementdavor = k;
        k = k.getNext();

        for (int i = 1; i < this.size(); i++) {
            if (o.equals(k.getWert())) {
                elementdavor.setNext(k.getNext());
                return true;
            }
            elementdavor = elementdavor.getNext();
            k = k.getNext();
        }
        return false;
       // throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public boolean containsAll(Collection c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'containsAll'");
    }

    @Override
    public boolean addAll(Collection c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean addAll(int index, Collection c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean removeAll(Collection c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAll'");
    }

    @Override
    public boolean retainAll(Collection c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retainAll'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public Object get(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public Object set(int index, Object element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public void add(int index, Object element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public Object remove(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Element<T> aktuell = kopf;
        while (aktuell != null) {
            if (aktuell.getWert().equals(o)) {
                return index;
            }
            aktuell = aktuell.getNext();
            index = index + 1;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lastIndexOf'");
    }

    @Override
    public ListIterator listIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public ListIterator listIterator(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subList'");
    }
}
