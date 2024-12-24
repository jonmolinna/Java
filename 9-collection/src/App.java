import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) throws Exception {
        // Sets
        //---------------------------- A. HashSet
        // El conjunto de datos no se almacena en un orden específico, 
        // si bien se garantiza que no hay duplicados.
        Set<String> language = new HashSet<String>();
        // add
        language.add("Python");
        language.add("React");
        language.add("Angular");
        language.add("Java");

        // exists
        language.contains("Angular");

        // remove
        language.remove("React");

        // size
        language.size();

        // clear
        language.clear();
        
        // verifica que el set esta vacio
        language.isEmpty();

        if (language.isEmpty()) {
            System.out.println("No tienes lenguajes disponibles");
        }
        else {
            System.out.println("Hay lenguajes disponibles");
        }

       // Recorrer
       for(String i : language) {
        System.out.println(i);
       }

       System.out.println("-----------------------------");

       //---------------------------- B. Treeset
       // Los elementos del conjunto se almacenan de menor a mayor.
       // usa los mismos metodos de la primera
       Set<String> languagues = new TreeSet<String>();
       languagues.add("Vue");
       languagues.add("Php");
       languagues.add("Nest js");
       languagues.add("Java");

       // recorrido
       for(String i : languagues) {
        System.out.println(i);
       }

       //---------------------------- C. LinkedHashSet
       // Los elementos del conjunto se encuentran en el orden que se insertan, 
       // similar a una lista pero sin dejar ingresar valores repetido.
       // usa los mismos metodos de la primera
       Set<String> lenguajes = new LinkedHashSet<String>();
       lenguajes.add("Python");
       lenguajes.add("Java");

    }
}
