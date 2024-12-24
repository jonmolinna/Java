import interfaces.Comunicable;

public class Delfin extends CriaturasMarinas implements Comunicable {
    
    public Delfin(String name) {
        super(name);
    }

    @Override
    void nadar() {
        System.out.println(name + " Esta nadando");
    }

    @Override
    public void comunicarse() {
        System.out.println(name + " emite sonidos para comunicarse");
    }
}
