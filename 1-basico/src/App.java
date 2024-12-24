import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hola Mundo");

        // Variables
        // a. Variables primitivas
        int number = 5;
        double decimales = 4.34;
        char letra = 's';
        boolean v = true;

        // b. Variables referencias
        String str = "this is a comment";

        // Strings
        String cadena = "This is my comment in java";

        // a. Longitud
        int len = cadena.length();
        System.out.println(len);

        // b. substring
        String subcadena = cadena.substring(4, 18);
        System.out.println(subcadena);

        // c. toLowerCase
        String lower = cadena.toLowerCase();
        System.out.println(lower);

        // d. contains
        boolean contain = cadena.contains("java");
        System.out.println(contain);


        // Operadores
        int a = 5;
        int b = 6;
        int c = a + b;

        System.out.println(c);

        // Condiciones
        int age = 19;

        if (age >= 18) {
            System.out.println("Puedes conducir");
        } else {
            System.out.println("No puedes conducir");
        }

        // Switch
        String bebida = "agua";

        switch (bebida) {
            case "cafe":
                System.out.println("Cafe");
                break;
            case "mate":
                System.out.println("mate");
                break;
            default:
                System.out.println("Buena eleccion");
                break;
        }

        // Practica 1
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a la maquina expendedora de bebidas");
        System.out.println("Eligi una opcion de las siguientes: ");
        System.out.println("1 - Cafe");
        System.out.println("2 - Mate");
        System.out.println("3 - Gaseosa");
        System.out.println("4 - Vino");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Eligiste cafe");
                break;
            case 2:
                System.out.println("Eligiste mate");
                break;
            case 3:
                System.out.println("Eligiste Gaseosa");
                break;
            case 4:
                System.out.println("Eligiste vino");
                break;
            default:
                System.out.println("Opcion no valida, fin de programa");
                break;
        }

        scanner.close();

    }
}
