public class Cliente {

    String nome;
    long cpf;
    float soma;
    public Cliente(String nome, long cpf){
        this.nome = nome;
        this.cpf = cpf;
    }
    public String getNome() {
        return this.nome;
    }
    public long getCpf() {
        return this.cpf;
    }
    public float CalculaTotalCompra (float newcompra){
        soma += newcompra;
        return soma;
    }
}
