public class Animal {
    String name;
    int age;
    // static que sus valores no se reinicia, cada que que se instancia sus valores suman.
    // tambien puede ser accedido por cualquier clase
    static int count = 0;

    public Animal (String name, int age) {
        this.name = name;
        this.age = age;
        count++;
    }

    public String sonido() {
        return "Hacer sonido generico";
    }

    public static int getQuantityAnimals() {
        return count;
    }

}
