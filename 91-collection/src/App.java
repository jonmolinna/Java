import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Vector;

public class App {
    public static void main(String[] args) throws Exception {
        // List
        //----------------------- A. ArrayList
        ArrayList<String> languagues = new ArrayList<String>();

        // Insert
        languagues.add("Python");
        languagues.add("Java");
        languagues.add("Php");
        languagues.add("Vue");

        // Acceder Item
        languagues.get(1);

        // Cambiar Item
        languagues.set(3, "Angular");

        // varificar
        languagues.contains("Php");

        // remove
        languagues.remove(2);

        // size
        languagues.size();

        // sort
        Collections.sort(languagues);

        // clear
        languagues.clear();

        //----------------------- B. LinkedList
        LinkedList<String> foods = new LinkedList<>();

        //----------------------- C. Vector
        // Multi Hilo
        Vector<String> names = new Vector<>();

    }
}
