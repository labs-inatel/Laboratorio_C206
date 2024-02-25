public class MemoriaUSB {
    String nome;
    int capacidade;

    public MemoriaUSB(String nome, int capacidade){
        this.nome = nome;
        this.capacidade = capacidade;
    }
    public String getNome() {
        return this.nome;
    }
    public int getCapacidade() {
        return this.capacidade;
    }
}
