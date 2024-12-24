import Exceptions.CalculadoraException;
import Exceptions.DividirByZeroException;

public class App {
    public static void main(String[] args) throws Exception {
        double number1 = 10;
        double number2 = 0;
        double resultado;

        Calculadora calculadora = new Calculadora();

        System.err.println("<------------------->");

        // try {
        //     resultado = number1 / number2;
        //     System.out.println(resultado);
        // } catch (Exception e) {
        //     e.printStackTrace();
            
        // }

        try {
            resultado = calculadora.dividir(number1, number2);
            System.out.println(resultado);

        // } catch (DividirByZeroException e) {
        } catch (CalculadoraException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Loading is false");
        }
    }
}
