public class App {
    public static void main(String[] args) throws Exception {
        int[] number = new int[5];

        number[0] = 10;
        number[1] = 20;
        number[2] = 30;
        number[3] = 40;
        number[4] = 50;

        // Length
        for (int i = 0; i < number.length; i++) {
            System.out.println(number[i]);
        }

        int[] numeros = {10, 20, 30, 40, 50};
        int indice = 0;

        for (int numero : numeros) {
            System.out.println(numero);
            System.out.println(indice);
            indice++;
        }

        // String palabra = "Kendra Contreras";
        // System.out.println(palabra.length());
        
    }
}
