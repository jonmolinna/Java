public class Carrera {
    String name;
    int duration;
    boolean inCurso;

    // Constructor
    public Carrera(String name, int duration, boolean inCurso) {
        this.name = name;
        this.duration = duration;
        this.inCurso = inCurso;
    }

    public Carrera(String name) {
        this.name = name;
    }

}
