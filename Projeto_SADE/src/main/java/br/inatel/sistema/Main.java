package br.inatel.sistema;

import br.inatel.sistema.BD.*;
import br.inatel.sistema.usuarios.*;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int idEscola;

    public static void main(String[] args) {
        EscolaBD escolaBD = new EscolaBD();

        System.out.println("\nBEM-VINDO AO SISTEMA:\n");
        System.out.println("Para validarmos o seu acesso ao sistema, por favor insira corretamente " +
                "o número de identificação da escola cadastrada:");

        idEscola = sc.nextInt();
        sc.nextLine();

        //------------------------------ENTRANDO COM O ID NO SISTEMA-----------------------------------
        while (idEscola != -1) {
            if (escolaBD.validacao(idEscola))
                Sistema();
            else {
                primeiroAcesso();
                System.out.println("Para validarmos o seu acesso ao sistema, por favor insira corretamente " +
                        "o número de identificação da escola cadastrada:");
                idEscola = sc.nextInt();
                sc.nextLine();
            }
        }
    }
    public static void Sistema() {
        DiretorBD diretorBD = new DiretorBD();
        CoordenadorBD coordenadorBD = new CoordenadorBD();
        AlunoBD alunoBD = new AlunoBD();
        ProfessorBD professorBD = new ProfessorBD();
        EscolaBD escolaBD = new EscolaBD();
        TurmaBD turmaBD = new TurmaBD();

        boolean flag = true;
        int menu;//para menu 1

        while (flag) {

            System.out.println("\nBEM-VINDO AO SISTEMA:\n");
            System.out.println("1 - Interação Aluno");
            System.out.println("2 - Interação Professor");
            System.out.println("3 - Cadastramento de Direção");
            System.out.println("4 - Cadastramento de Coordenação");
            System.out.println("5 - Busca de dados de escolas cadastradas");
            System.out.println("6 - Busca de dados de diretores cadastrados");
            System.out.println("7 - Busca de dados de coordenadores cadastrados");
            System.out.println("8 - Listagem de turmas cadastradas");
            System.out.println("9 - Atualização de dados das escolas");
            System.out.println("10 - Atualização de dados das diretores");
            System.out.println("11 - Atualização de dados das coordenadores");
            System.out.println("12 - Cancelamento de cadastro de escola");
            System.out.println("13 - Cancelamento de cadastro de diretor");
            System.out.println("14 - Cancelamento de cadastro de coordenador");
            System.out.println("15 - Sair");
            System.out.println("\nEntre com a sua opção:");

            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1 -> {
                    //--------------------------------USUARIO ALUNO--------------------------------------
                    System.out.println("\nBEM VINDO AO MENU:\n");
                    System.out.println("1 - Cadastramento de alunos");
                    System.out.println("2 - Busca de dados de alunos cadastrados");
                    System.out.println("3 - Atualização de dados dos alunos:");
                    System.out.println("4 - Cancelamento de matrícula");
                    System.out.println("5 - Sair");
                    System.out.println("\nEntre com a sua opção: ");

                    int opcao = sc.nextInt();
                    sc.nextLine();

                    if (opcao == 1) {
                        //-------------------------CADASTRANDO ALUNO-------------------------------
                        System.out.println("\nInsira o nome da Escola de Origem do aluno:");
                        String escolaOrigem;
                        escolaOrigem = sc.nextLine();

                        System.out.println("\nInsira o nome completo do aluno:");
                        String nome;
                        nome = sc.nextLine();

                        System.out.println("\nInsira o cpf completo do aluno:");
                        String cpf;
                        cpf = sc.nextLine();

                        System.out.println("\nInsira o rg completo do aluno:");
                        String rg;
                        rg = sc.nextLine();

                        System.out.println("\nInsira a data de Nascimento do aluno:");
                        String dataNasc;
                        dataNasc = sc.nextLine();

                        System.out.println("\nInsira a Naturalidade do aluno:");
                        String naturalidade;
                        naturalidade = sc.nextLine();

                        System.out.println("\nInsira o sexo do aluno:");
                        String sexo;
                        sexo = sc.nextLine();

                        System.out.println("\nInsira o nome completo da filiação 1 (mãe): ");
                        String nomeFiliacao1;
                        nomeFiliacao1 = sc.nextLine();

                        System.out.println("\nInsira o nome completo da filiação 2 (pai): ");
                        String nomeFiliacao2;
                        nomeFiliacao2 = sc.nextLine();

                        if (nomeFiliacao2 == null) { //CASO O ALUNO NÃO POSSUA FILIAÇÃO 2(PAI)
                            break;
                        }

                        System.out.println("\nInsira o endereço completo do aluno:");
                        String endereco;
                        endereco = sc.nextLine();

                        System.out.println("\nInsira o telefone para contato do aluno:");
                        String contato;
                        contato = sc.nextLine();

                        System.out.println("\nInsira a série e turma do aluno:");
                        int serie;
                        serie = sc.nextInt();
                        int turma;
                        turma = sc.nextInt();
                        int idTurma = 0;

                        while(idTurma == 0) {
                            if (turmaBD.validaTurma(serie,turma,idEscola) == 0) {
                                System.out.println("A serie e turma inserida é inválida!");
                                System.out.println("\nInsira uma nova série e turma do aluno:");
                                serie = sc.nextInt();
                                turma = sc.nextInt();
                            }
                            idTurma = turmaBD.validaTurma(serie,turma,idEscola);
                        }

                        Aluno aluno = new Aluno(escolaOrigem, nome, cpf, rg, dataNasc, naturalidade,
                                sexo, nomeFiliacao1, nomeFiliacao2, endereco, contato, idTurma, idEscola);

                        alunoBD.insertAluno(aluno);

                    } else if (opcao == 2)
                        alunoBD.researchAluno(); // BUSCANDO DADOS DE ALUNO CADASTRADO

                    else if (opcao == 3) {
                        //--------------ATUALIZANDO ENDEREÇO OU CONTATO DO ALUNO------------
                        System.out.println("\nMENU de atualização:\n");
                        System.out.println("1 - Atualizar endereço");
                        System.out.println("2 - Atualizar contato");
                        System.out.println("3 - Atualizar turma do aluno");
                        System.out.println("4 - Sair do menu de atualização");
                        System.out.println("\nEntre com a sua opção:");

                        int atualizo = sc.nextInt();
                        int matriculaAt;

                        if (atualizo == 1) {
                            //-----------------------ATUALIZANDO ENDEREÇO------------------------
                            System.out.println("Digite o número de matricula do aluno para atualização:");
                            matriculaAt = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Digite o novo endereço:");
                            String enderecoAt = sc.nextLine();

                            alunoBD.updateAlunoEnd(matriculaAt, enderecoAt);

                        } else if (atualizo == 2) {
                            //---------------------ATUALIZANDO CONTATO-----------------------
                            System.out.println("Digite o número de matricula do aluno para atualização:");
                            matriculaAt = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Digite o novo contato:");
                            String contatoAt = sc.nextLine();

                            alunoBD.updateAlunoCont(matriculaAt, contatoAt);

                        } else if (atualizo == 3){
                            //---------------------ATUALIZANDO CONTATO-----------------------
                            System.out.println("Digite o número de matricula do aluno para atualização:");
                            matriculaAt = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Insira a nova serie e turma do aluno para atualização:");
                            int serieAt;
                            serieAt = sc.nextInt();
                            int turmaAt;
                            turmaAt = sc.nextInt();
                            int idTurma = 0;

                            while(idTurma == 0) {
                                if (turmaBD.validaTurma(serieAt,turmaAt,idEscola) == 0) {
                                    System.out.println("A serie e turma inserida é inválida!");
                                    System.out.println("\nInsira uma nova série e turma do aluno:");
                                    serieAt = sc.nextInt();
                                    turmaAt = sc.nextInt();
                                }
                                idTurma = turmaBD.validaTurma(serieAt,turmaAt,idEscola);
                            }
                            alunoBD.updateTurma(matriculaAt, idTurma);
                        }
                    } else if (opcao == 4) {
                        //-----------------EXCLUINDO MATRÍCULA DO ALUNO----------------------
                        System.out.println("Digite o número de matrícula do Aluno a ser deletado:");
                        int id = sc.nextInt();

                        alunoBD.deleteAluno(id);
                    }
                }
                case 2 -> {
                    //-----------------------------USUARIO PROFESSOR-------------------------------------
                    System.out.println("\nBEM-VINDO AO MENU:\n");
                    System.out.println("1 - Cadastramento de Professores");
                    System.out.println("2 - Busca de dados de Professores");
                    System.out.println("3 - Atualização de dados Professores");
                    System.out.println("4 - Deletar dados de Professores");
                    System.out.println("5 - Sair");
                    System.out.println("\nEntre com a sua opção: ");

                    int opcao1 = sc.nextInt();
                    sc.nextLine();

                    if (opcao1 == 1) {
                        //-----------------------------CADASTRANDO PROFESSOR---------------------------------
                        System.out.println("\nInsira seu nome completo:");
                        String pnome;
                        pnome = sc.nextLine();

                        System.out.println("\nInsira seu cpf:");
                        String pcpf;
                        pcpf = sc.nextLine();

                        System.out.println("\nInsira seu rg:");
                        String prg;
                        prg = sc.nextLine();

                        System.out.println("\nInsira sua data de Nascimento:");
                        String pdataNasc;
                        pdataNasc = sc.nextLine();

                        System.out.println("\nInsira sua naturalidade:");
                        String pnaturalidade;
                        pnaturalidade = sc.nextLine();

                        System.out.println("\nInsira seu sexo:");
                        String psexo;
                        psexo = sc.nextLine();

                        System.out.println("\nInsira seu cargo: ");
                        String cargo;
                        cargo = sc.nextLine();

                        System.out.println("\nInsira a disciplina dada: ");
                        String disciplina;
                        disciplina = sc.nextLine();

                        System.out.println("\nInsira seu endereço completo:");
                        String pendereco;
                        pendereco = sc.nextLine();

                        System.out.println("\nInsira seu telefone para contato:");
                        String pcontato;
                        pcontato = sc.nextLine();

                        Professor professor = new Professor(pnome, pcpf, prg, pdataNasc, pnaturalidade, psexo,
                                cargo, disciplina, pendereco, pcontato);

                        professorBD.insertProfessor(professor);

                        int idProfessor = professorBD.getLastId();

                        professorBD.ProfessorEscola(idProfessor,idEscola);

                        int choice;
                        int serie;
                        int turma;

                        do{
                        System.out.println("Insira a serie e turma onde o professor atua:");
                        serie = sc.nextInt();
                        turma = sc.nextInt();

                        int idTurma = 0;

                        while(idTurma == 0) {
                            if (turmaBD.validaTurma(serie,turma,idEscola) == 0) {
                                System.out.println("A serie e turma inserida é inválida!");
                                System.out.println("\nInsira uma nova série e turma para o professor:");
                                serie = sc.nextInt();
                                turma = sc.nextInt();
                            }
                            idTurma = turmaBD.validaTurma(serie,turma,idEscola);
                        }
                            professorBD.ProfessorTurma(idProfessor, idTurma);

                            System.out.println("Continuar inserindo turmas?");
                            System.out.println("1 - Sim");
                            System.out.println("2 - Não");
                            choice = sc.nextInt();
                        }while (choice != 2);

                    } else if (opcao1 == 2)
                        professorBD.researchProfessor();  // BUSCANDO DADOS DE PROFESSOR CADASTRADO

                    else if (opcao1 == 3) {
                        //----------ATUALIZANDO ENDEREÇO OU CONTATO DO PROFESSOR------------
                        System.out.println("\nMENU de atualização:\n");
                        System.out.println("1 - Atualizar endereço");
                        System.out.println("2 - Atualizar contato");
                        System.out.println("3 - Sair do menu de atualização");
                        System.out.println("\nEntre com a sua opção:");

                        int atualizo = sc.nextInt();
                        int matriculaAt;

                        if (atualizo == 1) {
                            //------------------------ATUALIZANDO ENDEREÇO-----------------------
                            System.out.println("Digite o número de matricula do aluno para atualização:");
                            matriculaAt = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Digite o novo endereço:");
                            String enderecoAt = sc.nextLine();

                            professorBD.updateProfessorEnd(matriculaAt, enderecoAt);

                        } else if (atualizo == 2) {
                            //----------------------ATUALIZANDO CONTATO---------------------
                            System.out.println("Digite o número de matricula do aluno para atualização:");
                            matriculaAt = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Digite o novo contato:");
                            String contatoAt = sc.nextLine();

                            professorBD.updateProfessorCont(matriculaAt, contatoAt);
                        }
                    } else if (opcao1 == 4) {
                        //----------------EXCLUINDO PROFESSOR CADASTRADO------------------
                        System.out.println("Digite o número de identificação do professor a ser deletado:");
                        int id = sc.nextInt();

                        professorBD.deleteProfessor(id);
                    }
                }
                case 3 -> {
                    //-----------------------------CADASTRANDO DIRETOR----------------------------
                    System.out.println("Insira o nome do diretor:");
                    String nomeDiretor;
                    nomeDiretor = sc.nextLine();

                    System.out.println("Insira o CPF do diretor:");
                    String cpf;
                    cpf = sc.nextLine();

                    System.out.println("Insira o RG do diretor:");
                    String rg;
                    rg = sc.nextLine();

                    System.out.println("Insira a data de Nascimento do Diretor:");
                    String dataNasc;
                    dataNasc = sc.nextLine();

                    System.out.println("Insira a naturalidade do Diretor:");
                    String naturalidade;
                    naturalidade = sc.nextLine();

                    System.out.println("Insira o endereço do Diretor:");
                    String endereco;
                    endereco = sc.nextLine();

                    System.out.println("Insira um telefone para contato com o responsável pela escola:");
                    String contato;
                    contato = sc.nextLine();

                    Diretor diretor = new Diretor(nomeDiretor, cpf, rg, dataNasc, naturalidade, endereco, contato, idEscola);
                    diretorBD.insertDiretor(diretor);
                }
                case 4 -> {
                    //-----------------------------CADASTRANDO COORDENADOR----------------------------
                    System.out.println("Insira o nome do Coordenador:");
                    String nome;
                    nome = sc.nextLine();

                    System.out.println("Insira o CPF do Coordenador:");
                    String cpf;
                    cpf = sc.nextLine();

                    System.out.println("Insira o RG do Coordenador:");
                    String rg;
                    rg = sc.nextLine();

                    System.out.println("Insira a data de Nascimento do Coordenador:");
                    String dataNasc;
                    dataNasc = sc.nextLine();

                    System.out.println("Insira a naturalidade do Coordenador:");
                    String naturalidade;
                    naturalidade = sc.nextLine();

                    System.out.println("Insira o endereço do Coordenador:");
                    String endereco;
                    endereco = sc.nextLine();

                    System.out.println("Insira o contato do Coordenador:");
                    String contato;
                    contato = sc.nextLine();

                    Coordenador coordenador = new Coordenador(nome, cpf, rg, dataNasc, naturalidade, endereco, contato, idEscola);

                    coordenadorBD.insertCoordenador(coordenador);

                    int idCoordenador = coordenadorBD.getLastId();

                    turmaBD.updateCoordenador(idCoordenador,idEscola);
                }
                case 5 -> escolaBD.researchEscola(); // BUSCANDO DADOS DE ESCOLA CADASTRADA
                case 6 -> diretorBD.researchDiretor(); // BUSCANDO DADOS DE DIRETOR CADASTRADO
                case 7 -> coordenadorBD.researchCoordenador(); // BUSCANDO DADOS DE COORDENADOR CADASTRADO
                case 8 -> turmaBD.researchTurmas(); // BUSCANDO TURMAS CADASTRADAS
                case 9 -> {
                    //----------ATUALIZANDO LOCALIZAÇÃO OU CONTATO DA ESCOLA CADASTRADA--------------
                    System.out.println("\nMENU de atualização:\n");
                    System.out.println("1 - Atualizar endereço");
                    System.out.println("2 - Atualizar contato");
                    System.out.println("3 - Sair do menu de atualização");
                    System.out.println("\nEntre com a sua opção:");

                    int atualizo = sc.nextInt();
                    int idAt;

                    if (atualizo == 1) {
                        //--------------------------ATUALIZANDO ENDEREÇO--------------------------
                        System.out.println("Digite o número de identificação da escola para atualização:");
                        idAt = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Digite o novo endereço:");
                        String localizacaoAt = sc.nextLine();

                        escolaBD.updateEscolaEnd(idAt, localizacaoAt);

                    } else if (atualizo == 2) {
                        //-------------------------ATUALIZANDO CONTATO-------------------------------
                        System.out.println("Digite o número de identificação da escola para atualização:");
                        idAt = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Digite o novo contato:");
                        String contatoAt = sc.nextLine();

                        escolaBD.updateEscolaCont(idAt, contatoAt);
                    }
                }
                case 10 -> {
                    //----------ATUALIZANDO LOCALIZAÇÃO OU CONTATO DO DIRETOR CADASTRADO--------------
                    System.out.println("\nMENU de atualização:\n");
                    System.out.println("1 - Atualizar endereço");
                    System.out.println("2 - Atualizar contato");
                    System.out.println("3 - Sair do menu de atualização");
                    System.out.println("\nEntre com a sua opção:");

                    int atualizo = sc.nextInt();
                    int idAt;

                    if (atualizo == 1) {
                        //-----------------------ATUALIZANDO ENDEREÇO-----------------------------
                        System.out.println("Digite o número de identificação do diretor para atualização:");
                        idAt = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Digite o novo endereço:");
                        String enderecoAt = sc.nextLine();

                        diretorBD.updateDiretorEnd(idAt, enderecoAt);

                    } else if (atualizo == 2) {
                        //--------------------------ATUALIZANDO CONTATO--------------------------
                        System.out.println("Digite o número de identificação do diretor para atualização:");
                        idAt = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Digite o novo contato:");
                        String contatoAt = sc.nextLine();

                        diretorBD.updateDiretorCont(idAt, contatoAt);
                    }
                }
                case 11 -> {
                    //----------ATUALIZANDO LOCALIZAÇÃO OU CONTATO DA COORDENADOR CADASTRADO--------------
                    System.out.println("\nMENU de atualização:\n");
                    System.out.println("1 - Atualizar endereço");
                    System.out.println("2 - Atualizar contato");
                    System.out.println("3 - Sair do menu de atualização");
                    System.out.println("\nEntre com a sua opção:");

                    int atualizo = sc.nextInt();
                    int idAt;

                    if (atualizo == 1) {
                        //-----------------------ATUALIZANDO ENDEREÇO------------------------
                        System.out.println("Digite o número de identificação do coordenador para atualização:");
                        idAt = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Digite o novo endereço:");
                        String enderecoAt = sc.nextLine();

                        coordenadorBD.updateCoordenadorEnd(idAt, enderecoAt);

                    } else if (atualizo == 2) {
                        //------------------------ATUALIZANDO CONTATO---------------------------
                        System.out.println("Digite o número de identificação do coordenador para atualização:");
                        idAt = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Digite o novo contato:");
                        String contatoAt = sc.nextLine();

                        coordenadorBD.updateCoordenadorCont(idAt, contatoAt);
                    }
                }
                case 12 -> {
                    //----------------EXCLUINDO ESCOLA CADASTRADA------------------------------------
                    System.out.println("Digite o número de identificação da escola a ser deletada:");
                    int id = sc.nextInt();
                    escolaBD.deleteEscola(id);
                }
                case 13 -> {
                    //----------------EXCLUINDO DIRETOR CADASTRADO----------------------------------
                    System.out.println("Digite o número de identificação do diretor a ser deletado:");
                    int id = sc.nextInt();
                    diretorBD.deleteDiretor(id);
                }
                case 14 -> {
                    //----------------EXCLUINDO COORDENADOR CADASTRADO--------------------------------
                    System.out.println("Digite o número de identificação do coordenador a ser deletado:");
                    int id = sc.nextInt();
                    coordenadorBD.deleteCoordenador(id);
                }
                case 15 -> {// SAIR DO SISTEMA
                    idEscola = -1;
                    flag = false;
                }
            }
        }
    }
    public static void primeiroAcesso(){
        EscolaBD escolaBD = new EscolaBD();
        TurmaBD turmaBD = new TurmaBD();

        System.out.println("O Id inserido não consta no sistema!\n");
        System.out.println("Para utilização do sistema, por favor insira os respectivos dados a seguir:");
        System.out.println("Insira o nome da escola:");
        String nomeEscola;
        nomeEscola = sc.nextLine();

        System.out.println("Insira o CNPJ da escola:");
        String cnpj;
        cnpj = sc.nextLine();

        System.out.println("Insira a localização da escola:");
        String localizacao;
        localizacao = sc.nextLine();

        System.out.println("Insira o telefone para contato com a escola:");
        String telefone;
        telefone = sc.nextLine();

        Escola escola = new Escola(nomeEscola, cnpj, localizacao, telefone);

        escolaBD.insertEscola(escola); // CADASTRO DE ESCOLA

        idEscola = escolaBD.getLastId();

        System.out.println("\nPara finalizarmos, insira a quantidade de turmas para cada respectiva série:");
        for (int i = 0; i < 9; i++) {
            int turmas;
            int serie = i + 1;

            System.out.println("Quantidade de turmas para " + serie + "º ano:");
            turmas = sc.nextInt();

            if (turmas != 0) {
                Turmas turma = new Turmas(serie, turmas, idEscola);
                turmaBD.insertTurma(turma);
            }
        }
        System.out.println("Abaixo estão os dados registrados pra escola cadastrada:");
        escolaBD.researchEscola();  // APRESENTAÇÃO DE ID DA ESCOLA PARA PRIMEIRO ACESSO AO SISTEMA
    }
}
