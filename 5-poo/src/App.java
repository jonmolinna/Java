public class App {
    public static void main(String[] args) throws Exception {

        Persona person1 = new Persona("Kendra", "Contreras", 29, "Ciencias de la Computacion", 5, true);
        
        // Persona person1 = new Persona();
        // person1.name = "Kendra";
        // person1.surname = "Contreras";
        // person1.age = 29;

        // person1.carrera.name = "Ciencias de la Computacion";

        // Carrera carrera1 = new Carrera();
        // carrera1.name = "Ciencias de la Computacion";
        // carrera1.duration = 5;
        // carrera1.inCurso = false;

        // person1.carrera = carrera1;

        Persona person2 = new Persona("Malina", "Tanase", 24, "Administración y Ciencia de Datos para Negocios");
        // person2.name = "Malina";
        // person2.surname = "Tanase";
        // person2.age = 30;

        // person2.carrera.name = "Administración y Ciencia de Datos para Negocios";

        // Carrera carrera2 = new Carrera();
        // carrera2.name = "Administración y Ciencia de Datos para Negocios";
        // carrera2.duration = 5;
        // carrera2.inCurso = true;

        // person2.carrera = carrera2;

        // System.out.println(person1.name + " " + person1.surname);
        // System.out.println(person1.saludo("Malina Tanase"));
        System.out.println("");
        System.out.println(person1.nameSurname());
        System.out.println(person1.carrera.name);
        System.out.println("----------------------");
        System.out.println(person2.nameSurname());
        System.out.println(person2.carrera.name);
    }
}
