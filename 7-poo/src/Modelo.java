public abstract class Modelo {

    abstract double calcularArea();

    // Como esta la clase abstracta va a estar disponible para todas las clases que lo extends
    void printInfo() {
        System.out.println("Esta informacion viene desde la clase abstracta");
    }

}
