import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String strSecret = "inteligencia";
        int intentoMax = 10;
        int intentos = 0;
        boolean worldAdivinada = false;

        char[] letterAdivinada = new char[strSecret.length()];

        for(int i = 0; i < letterAdivinada.length; i++) {
            letterAdivinada[i] = '_';
        }

        while (!worldAdivinada && intentos < intentoMax) {
            System.out.println("Palabra a adivinar: " + String.valueOf(letterAdivinada) + " (" + strSecret.length() + " letra)");
            System.out.println("Introduce una letra: ");

            // Tomando la primera letra que ingreso
            char letra = Character.toLowerCase(scanner.next().charAt(0));
            boolean letraCorrecta = false;

            for (int i = 0; i < strSecret.length(); i++) {
                if (strSecret.charAt(i) == letra) {
                    letterAdivinada[i] = letra;
                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta) {
                intentos++;
                System.out.println("¡Incorrecto! te quedan " + (intentoMax - intentos) + " Intentos.");
            }

            if (String.valueOf(letterAdivinada).equals(strSecret)) {
                worldAdivinada = true;
                System.out.println("Has adivinado la palabra secreta: " + strSecret);
            }
        }

        if (!worldAdivinada) {
            System.out.println("¡Te has quedado sin numero de intentos!");
        }

        scanner.close();

    }
}
