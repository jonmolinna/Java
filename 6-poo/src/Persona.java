public class Persona {
    private String name;
    private String surname;
    private int age;

    // Contructor
    public Persona(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    // Metodos
    public String nameSurname() {
        return getName() + " " + getSurname();
    }

    // Encapsulamiento
    // getters - setters
    public int getAge() {
        return age;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
