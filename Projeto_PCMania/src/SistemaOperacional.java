public class SistemaOperacional {
    String nome;
    int tipo;
    public SistemaOperacional(String nome, int tipo){
        this.nome = nome;
        this.tipo = tipo;
    }
    public String getNome() {
        return this.nome;
    }
    public int getTipo() {
        return this.tipo;
    }
}
