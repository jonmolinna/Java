import interfaces.Comunicable;

public class Pulpo extends CriaturasMarinas implements Comunicable {
    int tentaculo;

    public Pulpo (String name, int tentaculo) {
        super(name);
        this.tentaculo = tentaculo;
    }

    @Override
    void nadar() {
        System.out.println(name + " tiene " + tentaculo + " tentaculos");
    }

    @Override
    public void comunicarse() {
        System.out.println(name + " se comunican mediante gestos y colores");
    }
}
