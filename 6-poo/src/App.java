public class App {
    public static void main(String[] args) throws Exception {
        Persona person1 = new Persona("Kendra", "Contreras", 29);
        person1.setName("Meryem");
        
        System.out.println("");
        System.out.println("Names: " + person1.nameSurname());
        System.out.println("Age: " + person1.getAge());

        System.out.println("----------------------------------");

        Animal animal = new Animal("Sin nombre", 120);
        Gato gato = new Gato("Isabel", 10);
        Perro perro = new Perro("Loqui", 4);

        System.out.println(perro.name);
        System.out.println(perro.sonido());

        System.out.println("El total de animales creados es: " + Animal.getQuantityAnimals());
    }
}
