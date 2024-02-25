package br.inatel.sistema.usuarios;

public class Coordenador {
    private String nome;
    private final String cpf;
    private final String rg;
    private final String dataNasc;
    private final String naturalidade;
    private String endereco;
    private String contato;
    private final int idEscola;
    private int id;

    public Coordenador (String nome, String cpf,  String rg, String dataNasc, String naturalidade,
                        String endereco, String contato, int idEscola){
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNasc = dataNasc;
        this.naturalidade = naturalidade;
        this.endereco = endereco;
        this.contato = contato;
        this.idEscola = idEscola;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {return rg;}

    public String getDataNasc() {
        return dataNasc;
    }

    public String getNaturalidade() {return naturalidade;}

    public String getEndereco() {
        return endereco;
    }

    public String getContato() {
        return contato;
    }

    public int getId(){ return id; }

    public int getIdEscola() {
        return idEscola;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public void setId(int id) {
        this.id = id;
    }
}
