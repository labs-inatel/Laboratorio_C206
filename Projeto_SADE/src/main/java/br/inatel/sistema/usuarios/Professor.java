package br.inatel.sistema.usuarios;

public class Professor{
    private String nome;
    private final String cpf;
    private final String rg;
    private final String dataNasc;
    private final String naturalidade;
    private final String sexo;
    private final String cargo;
    private final String disciplina;
    private String endereco;
    private String contato;
    private int id;

    public Professor (String nome, String cpf,  String rg, String dataNasc, String naturalidade, String sexo,
                      String cargo, String disciplina, String endereco, String contato){
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNasc = dataNasc;
        this.naturalidade = naturalidade;
        this.sexo = sexo;
        this.cargo = cargo;
        this.disciplina = disciplina;
        this.endereco = endereco;
        this.contato = contato;
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

    public String getSexo() {
        return sexo;
    }

    public String getCargo() {
        return cargo;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getContato() {
        return contato;
    }

    public int getId(){ return id; }

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

