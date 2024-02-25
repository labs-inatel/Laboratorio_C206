package br.inatel.sistema.usuarios;

public class Aluno{
    private final String escolaOrigem;
    private String nome;
    private final String cpf;
    private final String rg;
    private final String dataNasc;
    private final String naturalidade;
    private final String sexo;
    private final String nomeFiliacao1;
    private final String nomeFiliacao2;
    private String endereco;
    private String contato;
    private int matricula;

    private final int idTurma;
    private final int idEscola;

    public Aluno (String escolaOrigem, String nome, String cpf, String rg, String dataNasc, String naturalidade,
                  String sexo, String nomeFiliacao1, String nomeFiliacao2, String endereco, String contato,
                  int idTurma, int idEscola){
        this.escolaOrigem = escolaOrigem;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNasc = dataNasc;
        this.naturalidade = naturalidade;
        this.sexo = sexo;
        this.nomeFiliacao1 = nomeFiliacao1;
        this.nomeFiliacao2 = nomeFiliacao2;
        this.endereco = endereco;
        this.contato = contato;
        this.idTurma = idTurma;
        this.idEscola = idEscola;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getEscolaOrigem() {
        return escolaOrigem;
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

    public String getNomeFiliacao1() {
        return nomeFiliacao1;
    }

    public String getNomeFiliacao2() {
        return nomeFiliacao2;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getContato() {
        return contato;
    }

    public int getIdTurma() { return idTurma; }

    public int getIdEscola() { return idEscola; }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
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

}

