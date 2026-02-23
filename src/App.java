
public class App{

    // Testmethode - gibt alle values aus der Liste an - Martin 2026-02-23 13:30
    public static <T> void ausgabeListe(Liste<T> list){
        Element <T> node = list.getKopf();
        for(int i = 0; i<list.size(); i++){
            System.out.println(node.getWert());
            node = node.getNext();
        }    
        System.out.println("------------");
    }
    public static void main(String[] args) throws Exception {
        Liste<String> liste = new Liste<>("KOPF");
        // test


        //test

        
    }
}
