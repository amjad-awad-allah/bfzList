import java.util.ArrayList;
import java.util.Collection;

<<<<<<< HEAD
import java.util.ArrayList;

public class App{
=======
public class App {
>>>>>>> cac11b9d4e0ed5a133e7f7767c58cbc96e6000ed

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
        liste.add("Banane");
        liste.add("Clementine");
        ausgabeListe(liste);

        System.out.println(liste.remove("KOPF"));
        ausgabeListe(liste);

<<<<<<< HEAD
        // Test für addAll
        ArrayList<String> coll = new ArrayList<>();
        coll.add("Banana");
        coll.add("Cherry");
        boolean changed = liste.addAll(coll);
        System.out.println("Changed: " + changed);
        ausgabeListe(liste);
=======
        Collection<String> zuLoeschen = new ArrayList<>();
        zuLoeschen.add("Apfel");
        zuLoeschen.add("Clementine");
>>>>>>> cac11b9d4e0ed5a133e7f7767c58cbc96e6000ed

        // Rufe removeAll auf
        boolean geaendert = liste.removeAll(zuLoeschen);

        System.out.println("Liste geändert: " + geaendert); // true
        System.out.println("Neue Größe: " + liste.size()); // 2 (B, D übrig)

    }
}
