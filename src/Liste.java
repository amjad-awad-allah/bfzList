import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



// ---------------------------------------------------------//



// Gruppe A: Martin, Lenur, Marcel, Johannes, Amjad = contains Methode
// Gruppe B: Justyn, Aykut, André, Katharina = size und empty methoden
 

// ✅️ = Fertig: getestet & funktioniert
// ⚠️ = In Bearbeitung von
// ❌ = Noch nicht gemacht

// ✅️ Konstruktor 

// ✅️ getKopf() 

// ✅️ size()                                            Gruppe: B

// ✅️ isEmpty()                                         Gruppe: B

// ✅️ contains(Object o)                                Gruppe: A

// ❌ public Iterator iterator()  //optional            Gruppe: ❓

// ⚠️ Object[] toArray()                                Katharina

// ⚠️ Object[] toArray(Object[] a)                      Katharina 

// ✅️ boolean add(Object e)                             Gruppe: Gruppe A

// ✅️ boolean remove(Object o)                          Gruppe: Gruppe B

// ✅️  public boolean containsAll(Collection c)          Johannes, noch testen bitte

// ❌ public boolean addAll(Collection c)               Lenur

// ❌ public boolean addAll(int index, Collection c)    Gruppe: ❓

// ✅️  public boolean retainAll(Collection c) {          Gruppe: Johannes, noch testen

// ✅️ clear()                                           Gruppe: André, Johannes

// ⚠️ get(int index)                                    Amjad

// ⚠️ set(int index, Object element)                    Amjad

// ⚠️ void add(int index, Object element)               Martin

// ⚠️ T remove(int index)                               Gruppe: ❓ braucht testen

// ✅️ indexOf(Object o)                                 André

// ✅️ lastIndexOf(Object o)                             André

// ❌ listIterator()                                    Gruppe: ❓

// ❌ ListIterator listIterator(int index)              Gruppe: ❓

// ⚠️ List subList(int fromIndex, int toIndex)          Marcel

// ------------------------------------------------------------------------ //


public class Liste<T> implements List<T>{
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
    public int size() {   // 
        int size = 0;  // Zähler für die Anzahl der Elemente
        Element<T> k = this.getKopf();  // Startet beim Kopf der Liste

        // Durchläufe alle Elemente bis zum Ende der Liste
        while (k != null) {
            size++;  // Erhöhe den Zähler um 1
            k = k.getNext();  // Springe zum nächsten Element
        }
        return size;  // Gibt die Anzahl der Elemente zurück
       
    }

    @Override
    public boolean isEmpty() {
        return kopf == null;
        //throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public boolean contains(Object o) {
        Element<T> k = this.getKopf();  // Starte beim Kopf

        // Durchläufe alle Elemente
        while (k != null) {
            if (o.equals(k.getWert())) {  // Vergleiche mit aktuellem Element
                return true;  // Gefunden: gebe true zurück
            }
            k = k.getNext();  // Gehe zum nächsten Element
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
    public boolean add(T e) { // hier musste tatsächlich T e rein, da mit Object e keine new Element<> möglich wäre. Typesafety wäre dann nicht gegeben.
        Element<T> newE = new Element<>(e, null);
        Element<T> node = getKopf();
            if (node.getWert() == null){    // überprüfe zunächst ob der Kopf leer ist. Ohne würde ein null an erster Stelle übersprungen werden
                node.setWert(newE.getWert());
                return true;
            }
            while (node != null) {      // suche bis das nächste Element Leer ist, dann wird am Ende der Liste eine Element hinzugefügt
                if(node.getNext()==null){
                    node.setNext(newE);
                    return true;
                }
                node = node.getNext();
            }
            return true;
    }

    @Override
    public boolean remove(Object o) {
         if (!contains(o)) {  // Überprüfe zuerst, ob das Objekt existiert
            return false;
        }
        
        Element<T> k = this.getKopf();  // Starte beim Kopf

        // Spezialfall: Das zu löschende Element ist der Kopf
        if (o.equals(k.getWert())) {
            if (size() > 1) {
                setKopf(k.getNext());  // Setze neuen Kopf auf nächstes Element
            } else {
                setKopf(null);  // Wenn nur ein Element, setze Kopf auf null
            }
            return true;
        }
        
        // Das zu löschende Element ist nicht der Kopf
        Element<T> elementdavor = k;  // Element vor dem zu löschenden
        k = k.getNext();  // Aktuelles Element (das zu prüfende)

        // Durchlaufe die restliche Liste
        for (int i = 1; i < this.size(); i++) {
            if (o.equals(k.getWert())) {  // Gefunden!
                // Verbinde elementdavor direkt mit dem Element nach k (überspringe k)
                elementdavor.setNext(k.getNext());
                return true;
            }
            elementdavor = elementdavor.getNext();  // Verschiebe "davor" ein Element weiter
            k = k.getNext();  // Verschiebe aktuelles Element ein Element weiter
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        for(Object o:  c){
            if(!contains(o)){
                return false;
            }
        }
        return true;
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
        boolean changed  = false;  // Flag, um zu verfolgen, ob die Liste geändert wurde
        for ( Object o:c){
            while (remove(o)) {  // Entferne alle Vorkommen von o
                changed = true;  // Setze Flag auf true, wenn ein Element entfernt wurde
            }
        }
        return changed;
    }

    @Override
    public boolean retainAll(Collection c) { //nur elemente die auch in collection sind, sollen in der Liste bleiben //vergleiche mit getWert() von Objekt Element
        int listenGroesse = size();
        Element <T> node = kopf;
        for(int i = 0; i <listenGroesse; i ++){
            if(!c.contains(node.getWert())){
                
                remove(node);
            }else{
                node= node.getNext();
            }   

        }
        return true;
    }

    @Override
    public void clear() {
        kopf = null; //kein kopf = keine liste
    }

    @Override
    public T get(int index) {
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
    public T remove(int index) {
        if(index >= size()){
            return null;
        }
        if(index == 0) {
            Element<T> node = this.getKopf();
            if( size() > 1){
                
                this. setKopf(this.getKopf().getNext());
                return node.getWert();
            }
            setKopf(null);
            return node.getWert();
           
        }else{
            Element<T> node = this.getKopf().getNext();  // Starte beim Kopf // diese variable wird "gelöscht"
            Element<T> nodezwischElement = this.getKopf(); // diese variable wird den zeiger von der nodevariable übernehmen
            int zaehler= 1;
            while(zaehler < index){
                node = node.getNext();
                nodezwischElement = nodezwischElement.getNext();
                zaehler++;
            }
            nodezwischElement.setNext(node.getNext());
            return node.getWert();
        }
 
         //return null; hier würde der code nie hinkommen --> unreachable code
    

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
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int letzterIndex = -1;
        int aktuellerIndex = 0;
        Element<T> aktuell = kopf;
        while (aktuell != null) {
            if (aktuell.getWert().equals(o)) {
                letzterIndex = aktuellerIndex;
            }
            aktuell = aktuell.getNext();
            aktuellerIndex++;
        }
        return letzterIndex;
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
