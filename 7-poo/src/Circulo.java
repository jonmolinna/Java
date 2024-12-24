public class Circulo extends Modelo {
    double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    double calcularArea() {
        return Math.PI * this.radio * this.radio;
    }

}
