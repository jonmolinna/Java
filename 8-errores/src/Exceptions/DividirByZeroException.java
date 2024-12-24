package Exceptions;

public class DividirByZeroException extends Exception {
    @Override
    public String getMessage() {
        return "No se puede dividir por cero";
    }

}
