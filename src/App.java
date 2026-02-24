import java.util.ArrayList;
import java.util.Collection;

import java.util.ArrayList;

public class App{

    // Testmethode - gibt alle values aus der Liste an - Martin 2026-02-23 13:30
    public static <T> void ausgabeListe(Liste<T> list) {
        Element<T> node = list.getKopf();
        System.out.println("------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(node.getWert());
            node = node.getNext();
        }
        System.out.println("------------");
    }

    public static void main(String[] args) throws Exception {
        Liste<String> liste = new Liste<>("KOPF");

        liste.add("Apfel");
        liste.add("Apfel");
        liste.add("Clementine");
        ausgabeListe(liste);

        System.out.println(liste.remove("KOPF"));
        ausgabeListe(liste);

        // Test für addAll
        ArrayList<String> coll = new ArrayList<>();
        coll.add("Banana");
        coll.add("Cherry");
        boolean changed = liste.addAll(coll);
        System.out.println("Changed: " + changed);
        ausgabeListe(liste);

        // Rufe removeAll auf
        ArrayList<String> zuLoeschen = new ArrayList<>();
        zuLoeschen.add("Apfel");
        zuLoeschen.add("Clementine");
        boolean geaendert = liste.removeAll(zuLoeschen);

        System.out.println("Liste geändert: " + geaendert); // true
        System.out.println("Neue Größe: " + liste.size()); // 2 (B, D übrig)

        //test boolean retainAll(Collection c)
        System.out.println("Test retainAll: ");
        Collection<String> c = new ArrayList<>();
        Liste<String> testListe = new Liste<>("Banane"); //Kopfelement
        testListe.add("Banane");
        testListe.add("Apfel");
        testListe.add("Orange");
        c.add("Apfel");
        c.add("Apfel"); 
        c.add("Mandarine");
        System.out.println("Wahrheitswert für Methode retainall: " + testListe.retainAll(c));
        ausgabeListe(testListe);

        // test  boolean containsAll(Collection c) 
        Collection<String> collection2 = new ArrayList<>();
        Liste<String> testListe2 = new Liste<>("Banane"); //Kopfelement
        testListe2.add("Apfel");
        testListe2.add("Orange");
        collection2.add("Apfel");
        collection2.add("Banane");
        System.out.println("Die Liste enthält von jedem Unikat aus Collection einen gleichen Wert? : " + testListe2.containsAll(collection2)); //true
        collection2.add("Mandarine");
        System.out.println("Die Liste enthält von jedem Unikat aus Collection einen gleichen Wert? : " + testListe2.containsAll(collection2)); 
        

    

    }
}
