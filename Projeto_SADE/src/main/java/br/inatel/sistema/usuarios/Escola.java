package br.inatel.sistema.usuarios;

public class Escola {
    private String nome;
    private final String cnpj;
    private final String localizacao;
    private String contato;
    private int id;

    public Escola(String nome, String cnpj, String localizacao, String contato){
        this.nome = nome;
        this.cnpj = cnpj;
        this.localizacao = localizacao;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public String getContato() {
        return contato;
    }

    public int getId() { return id; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public void setId(int id) {
        this.id = id;
    }
}
