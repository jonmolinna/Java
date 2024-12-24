package Exceptions;

public class CalculadoraException extends Exception {
    String description;

    public CalculadoraException(String description) {
        // this.description = description;
        setDescription(description);
    }

    @Override
    public String getMessage() {
        return getDescription();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
