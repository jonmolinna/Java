import Exceptions.CalculadoraException;
import Exceptions.DividirByZeroException;

public class Calculadora {
    // public double dividir (double number1, double number2) throws DividirByZeroException {
        public double dividir (double number1, double number2) throws CalculadoraException {
        if (number2 == 0) throw new CalculadoraException("---> Nose puede dividir por cero");

        return number1 / number2;
    }

}
