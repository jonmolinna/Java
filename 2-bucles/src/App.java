public class App {
    public static void main(String[] args) throws Exception {
        // Bucle For
        for (int i = 1; i <= 3; i++ ) {
            System.out.println("for: " + i);
        }

        // Bucle While
        int contador = 1;
        while (contador <= 3) {
            System.out.println("while: " + contador);
            contador++;
        }

        // Do While
        int conn = 1;

        do {
            System.out.println("Do: " + conn);
            conn++;
        } while (conn <= 3);
    }

}
