package br.inatel.sistema.usuarios;

public class Turmas {
    private final int serie;
    private final int numTurma;
    private int id;

    public Turmas(int serie, int numTurma, int id){
        this.serie = serie;
        this.numTurma = numTurma;
        this.id = id;
    }

    public int getSerie() {
        return serie;
    }

    public int getNumTurma() {
        return numTurma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
