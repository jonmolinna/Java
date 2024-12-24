// extends herencia del padre
public class Gato extends Animal {
    public Gato(String name, int age) {
        // Constructor del padre
        super(name, age);
    }

    // Override -> sobre escribir el metodo (poliformismo)
    @Override
    public String sonido() {
        return "El gato Maulla";
    }
}
