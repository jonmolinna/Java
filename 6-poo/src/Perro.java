public class Perro extends Animal {
    public Perro(String name, int age) {
        super(name, age);
    }

    @Override
    public String sonido() {
        return "El perro ladra";
    }


}
