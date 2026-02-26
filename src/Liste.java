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

// ✅️ Object[] toArray()                             Katharina 

// ⚠️ Object[] toArray(Object[] a)                      Katharina

// ✅️ boolean add(Object e)                             Gruppe: Gruppe A

// ✅️ boolean remove(Object o)                          Gruppe: Gruppe B

// ✅️  public boolean containsAll(Collection c)         Johannes

// ✅️ public boolean addAll(Collection c)               Gruppe: Lenur

// ✅️ public boolean addAll(int index, Collection c)    Gruppe: Lenur

// ✅️ public boolean retainAll(Collection c) {          Gruppe: Johannes, noch testen

// ✅️ clear()                                           Gruppe: André, Johannes

// ✅️ get(int index)                                    Amjad, Martin,Edited by Amjad 

// ✅️ set(int index, Object element)                    Amjad, Martin,Edited by Amjad 

// ✅️ void add(int index, Object element)               Martin

// ✅️ T remove(int index)                               Johannes 

// ✅️ indexOf(Object o)                                 André

// ✅️  lastIndexOf(Object o)                             André

// ❌ listIterator()                                    Gruppe: ❓

// ❌ ListIterator listIterator(int index)              Gruppe: ❓

// ✅️ List subList(int fromIndex, int toIndex)          Gruppe: Marcel/ Lenur getestet

// ------------------------------------------------------------------------ //

public class Liste<T> implements List<T> {
    private Element<T> kopf;

    public Liste(T wert) {
        this.kopf = new Element<>(wert, null);
    }

    public Element<T> getKopf() {
        return kopf;
    }

    public void setKopf(Element<T> kopf) {
        this.kopf = kopf;
    }

    @Override
    public int size() { //
        int size = 0; // Zähler für die Anzahl der Elemente
        Element<T> k = this.getKopf(); // Startet beim Kopf der Liste

        // Durchläufe alle Elemente bis zum Ende der Liste
        while (k != null) {
            size++; // Erhöhe den Zähler um 1
            k = k.getNext(); // Springe zum nächsten Element
        }
        return size; // Gibt die Anzahl der Elemente zurück

    }

    @Override
    public boolean isEmpty() {
        return kopf == null;
        // throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public boolean contains(Object o) {
        Element<T> k = this.getKopf(); // Starte beim Kopf

        // Durchläufe alle Elemente
        while (k != null) {
            if (o.equals(k.getWert())) { // Vergleiche mit aktuellem Element
                return true; // Gefunden: gebe true zurück
            }
            k = k.getNext(); // Gehe zum nächsten Element
        }
        return false;
        // throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public Object[] toArray() {

        // Herausfinden der Länge der Liste
        int laengeListe = this.size();

        // Anlegen der Variablen der ausgegeben werden soll:
        Object[] ausgabeObjectArray = new Object[laengeListe];

        Element<T> k = this.getKopf(); // Startet beim Kopf der Liste

        int counter = 0;

        // Beschreiben des Arrays mit den Werten der Liste:

        while (k != null) {

            ausgabeObjectArray[counter] = k.getWert();

            k = k.getNext();

            counter++;

        }

        // Ausgabe des befüllten Arrays
        return ausgabeObjectArray;

        // throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    // -------------------@Override
    public Object[] toArray(Object[] a) {
    // Objectarray mit der Länge des größeren Arrays anlegen
    int limit = Math.max(a.length, this.size());

    // // alle Elemente mit null befüllen. Ginge schöner aber ¯\_(ツ)_/¯
    Object[] ausgabeObjectArray = new Object[limit];
    ausgabeObjectArray[limit-1]= null;

    Element<T> aktuell = this.kopf;
    // forloop die über die Länge der Liste geht
    for (int i = 0; i < this.size(); i++) {
        ausgabeObjectArray[i]= aktuell.getWert();
    // Schritt nach vorne
    aktuell = aktuell.getNext();
    }

    if (ausgabeObjectArray.length > limit) {
        ausgabeObjectArray[limit] = null;
    }
        // Ausgabe des befüllten Arrays
        return ausgabeObjectArray;
    }
    // ---------------------------------------------!--------------------------------------------------
    // //

    @Override
    public boolean add(T e) { // hier musste tatsächlich T e rein, da mit Object e keine new Element<> möglich
                              // wäre. Typesafety wäre dann nicht gegeben.
        Element<T> newE = new Element<>(e, null);
        Element<T> node = getKopf();
        if (node.getWert() == null) { // überprüfe zunächst ob der Kopf leer ist. Ohne würde ein null an erster Stelle
                                      // übersprungen werden
            node.setWert(newE.getWert());
            return true;
        }
        while (node != null) { // suche bis das nächste Element Leer ist, dann wird am Ende der Liste eine
                               // Element hinzugefügt
            if (node.getNext() == null) {
                node.setNext(newE);
                return true;
            }
            node = node.getNext();
        }
        return true;
    }
    // --------------------------------------------
    // Bessere Schreibweise für boolean add(T e): By Martin
    // --------------------------------------------
    //
    // public boolean add(T e) {
    // if (kopf == null){
    // kopf = new Element<>(e, null);
    // return true;
    // }
    // Element <T> node = this.getKopf();
    // while (node.getNext() != null) {
    // node = node.getNext();
    // }
    // node.setNext(new Element<>(e, null));
    // return true;
    // }
    // --------------------------------------------

    @Override
    public boolean remove(Object o) {
        if (!contains(o)) { // Überprüfe zuerst, ob das Objekt existiert
            return false;
        }

        Element<T> k = this.getKopf(); // Starte beim Kopf

        // Spezialfall: Das zu löschende Element ist der Kopf
        if (o.equals(k.getWert())) {
            if (size() > 1) {
                setKopf(k.getNext()); // Setze neuen Kopf auf nächstes Element
            } else {
                setKopf(null); // Wenn nur ein Element, setze Kopf auf null
            }
            return true;
        }

        // Das zu löschende Element ist nicht der Kopf
        Element<T> elementdavor = k; // Element vor dem zu löschenden
        k = k.getNext(); // Aktuelles Element (das zu prüfende)

        // Durchlaufe die restliche Liste
        for (int i = 1; i < this.size(); i++) {
            if (o.equals(k.getWert())) { // Gefunden!
                // Verbinde elementdavor direkt mit dem Element nach k (überspringe k)
                elementDavor.setNext(k.getNext());
                return true;
            }
            elementdavor = elementdavor.getNext(); // Verschiebe "davor" ein Element weiter
            k = k.getNext(); // Verschiebe aktuelles Element ein Element weiter
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        boolean listeenthaeltuniqueElementeAusCollection = true;
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;

    }

    @Override
    public boolean addAll(Collection c) {
        boolean changed = false; // Flag, um zu verfolgen, ob die Liste geändert wurde
        for (Object o : c) {
            add((T) o); // Füge jedes Element der Collection hinzu
            changed = true; // Setze Flag auf true, wenn ein Element hinzugefügt wurde
        }
        return changed; // Gibt true zurück, wenn die Liste geändert wurde
        // throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean addAll(int index, Collection c) {
        boolean changed = false;
        for (Object o : c) {
            add(index, (T) o); // Füge jedes Element der Collection an der angegebenen Position hinzu
            changed = true;
            index++; // Erhöhe den Index für das nächste Element
        }
        return changed;
        // throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean changed = false; // Flag, um zu verfolgen, ob die Liste geändert wurde
        for (Object o : c) {
            while (remove(o)) { // Entferne alle Vorkommen von o
                changed = true; // Setze Flag auf true, wenn ein Element entfernt wurde
            }
        }
        return changed;
    }

    @Override
    public boolean retainAll(Collection c) { // nur elemente die auch in collection sind, sollen in der Liste bleiben
                                             // //vergleiche mit getWert() von Objekt Element
        int listenGroesse = size();
        Element<T> node = getKopf();
        for (int i = 0; i < listenGroesse; i++) {
            if (!c.contains(node.getWert())) {

                remove(node);
            } else {
                node = node.getNext();
            }

        }
        return true;
    }

    @Override
    public void clear() {
        kopf = null; // kein kopf = keine liste
    }

    @Override
    public T get(int index) {//
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }

        return getNodeAt(index).getWert();

    }

    @Override
    public T set(int index, T element) {//
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        Element<T> current = getNodeAt(index);
        T oldValue = getNodeAt(index).getWert();
        current.setWert(element);

        return oldValue;
    }

    @Override
    public void add(int index, T wert) {

        int size = size(); // instanziiert, damit die funktion nicht immer wieder aufgerufen wird

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        } else if (index == 0) {
            kopf = new Element<>(wert, kopf);
        } else if (index == size) {
            add(wert);
        } else {
            Element<T> node = getKopf();
            for (int i = 0; i < index - 1; i++) { // schleife iteriert über übergabe-index, NICHT size.
                node = node.getNext(); // man such also das Element VOR dem übergabe-Index
            }
            node.setNext(new Element<>(wert, node.getNext())); // einfügen des elements zwischen VOR und nach dem Index.
        }
        size++;
    }

    @Override
    public T remove(int index) {
        if (index >= size()) {
            return null;
        }
        if (index == 0) {
            Element<T> node = this.getKopf();
            if (size() > 1) {

                this.setKopf(this.getKopf().getNext());
                return node.getWert();
            }
            setKopf(null);
            return node.getWert();

        } else {
            Element<T> node = this.getKopf().getNext(); // Starte beim Kopf // diese variable wird "gelöscht"
            Element<T> nodeZwischenElement = this.getKopf(); // diese variable wird den zeiger von der nodevariable
                                                           // übernehmen
            int zaehler = 1;
            while (zaehler < index) {
                node = node.getNext();
                nodeZwischenElement = nodeZwischenElement.getNext();
                zaehler++;
            }
            nodeZwischenElement.setNext(node.getNext());
            return node.getWert();
        }

        // return null; hier würde der code nie hinkommen --> unreachable code

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
    public Liste<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex) { // Überprüfe, ob die Indizes gültig sind
            // System.out.println("Invalid fromIndex or toIndex");
            throw new IndexOutOfBoundsException("Invalid fromIndex or toIndex");
        }
        Element<T> aktuell = kopf; // Das erste Element

        for (int i = 0; i < fromIndex; i++) { // Solange i kleiner als der Startindex ist
            aktuell = aktuell.getNext(); // gehen wir einen Index weiter
        }

        Liste<T> sublist = new Liste<T>(aktuell.getWert()); // Subliste mit Kopfwert der Indexposition von fromIndex
        aktuell = aktuell.getNext(); // Wir gehen eine Indexposition weiter und zeigen auf das nächste Element nach
                                     // fromIndex

        for (int i = fromIndex; i < toIndex; i++) { // Solange i kleiner/gleich der toIndex Position ist,
            sublist.add(aktuell.getWert()); // wird der sublist via ad-Methode ans Ende hinzugefügt
            aktuell = aktuell.getNext();
        }

        return sublist; // Rüchgabe der fertigen Sublist
    }

    /**
     * Amjad Awad Allah
     * Hilfsmethode, die das Element an der gegebenen Position findet.
     **/
    private Element<T> getNodeAt(int index) {
        Element<T> current = kopf;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current;
    }
}
