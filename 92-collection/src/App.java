import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) throws Exception {
        // Objectos
        // ------------------------ A. HashMap
        // No respeta el orden
        HashMap<String, Double> frutas = new HashMap<>();

        // Add
        frutas.put("Lima", 4.2);
        frutas.put("Naranja", 3.4);
        frutas.put("Fresa", 7.2);
        frutas.put("Sandia", 7.4);

        System.out.println("----------------------------->");

        // Recorrer
        for(String fruta : frutas.keySet()) {
            System.out.println(fruta + " : S/ " + frutas.get(fruta));
        }

        // Verificar
        String searchFruta = "Platano";

        if(frutas.containsKey(searchFruta)) {
            System.out.println("Esta la fruta");
        }
        else {
            System.out.println("No existe la fruta");
        }

        // Size
        frutas.size();


        // ------------------------ B. TreeMap
        // Ordena en forma ascendiente
        TreeMap<String, Double> names = new TreeMap<>();

        // ------------------------ C. LinkedHashMap()
        // Ordena en el orden que fue agregado los datos
        LinkedHashMap<String, Double> countries = new LinkedHashMap<>();


    }
}
