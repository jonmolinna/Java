public class App {
    public static void main(String[] args) throws Exception {
        Circulo circulo = new Circulo(5);
        Rectangulo rectangulo = new Rectangulo(5, 2);

        circulo.printInfo();
        System.out.println("La area del circulo es: " + circulo.calcularArea()); 
        System.out.println("La area del rectangulo es: " + rectangulo.calcularArea()); 

        System.out.println("<-------------------------------------->");

        Delfin delfin = new Delfin("Larry");
        Pulpo pulpo = new Pulpo("Calamardo", 8);

        delfin.nadar();
        delfin.comunicarse();

        pulpo.nadar();
        pulpo.comunicarse();

    }
}
