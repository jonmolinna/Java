public class Persona {
    public String name;
    public String surname;
    public int age;
    public Carrera carrera;

    // Contructor
    public Persona(String name, String surname, int age, String nameCarrera, int duration, boolean inCurso) {
        carrera = new Carrera(nameCarrera, duration, inCurso);
        // carrera = new Carrera();
        this.name = name;
        this.surname = surname;
        this.age = age;
        // carrera.name = nameCarrera;
    }

    // Sobre Carga Contructor
    public Persona(String name, String surname, int age, String nameCarrera) {
        carrera = new Carrera(nameCarrera);
        // carrera = new Carrera();
        this.name = name;
        this.surname = surname;
        this.age = age;
        // carrera.name = nameCarrera;
    }

    public String nameSurname() {
        return name + " " + surname;
    }

    public String saludo(String name) {
        return "Hola " + name;
    }

}
