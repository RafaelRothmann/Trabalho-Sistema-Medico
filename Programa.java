import java.text.*;
import java.util.*;

public class Programa {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        contasIniciais(); //Inicia já com 1 administrador, 11 médicos e 11 pacientes
        examesIniciais(); //Inicia com 10 autorizações
        menuContas(); //Inicia o menu principal
    }

    public static void contasIniciais() {
        Sistema.adicionarAdministrador(new Administrador("Sales", 1));

        Sistema.adicionarMedico(new Medico("Vicenzo", 10, AreasAtuacao.UROLOGIA));
        Sistema.adicionarMedico(new Medico("Joao", 11, AreasAtuacao.GERIATRIA));
        Sistema.adicionarMedico(new Medico("Rafael", 12, AreasAtuacao.PSIQUIATRIA));
        Sistema.adicionarMedico(new Medico("Murilo", 13, AreasAtuacao.HEMATOLOGIA));
        Sistema.adicionarMedico(new Medico("Antonio", 14, AreasAtuacao.DERMATOLOGIA));
        Sistema.adicionarMedico(new Medico("Rodrigo", 15, AreasAtuacao.OFTALMOLOGIA));
        Sistema.adicionarMedico(new Medico("Diogo", 16, AreasAtuacao.COLONOSCOPISTA));
        Sistema.adicionarMedico(new Medico("Vicente", 17, AreasAtuacao.RADIOLOGIA));
        Sistema.adicionarMedico(new Medico("Renato", 18, AreasAtuacao.OTORRINOLARINGOLOGIA));
        Sistema.adicionarMedico(new Medico("Steve", 19, AreasAtuacao.GASTROENTELOGIA));
        Sistema.adicionarMedico(new Medico("Bill", 20, AreasAtuacao.ENDOCRINOLOGIA));

        Sistema.adicionarPaciente(new Paciente("Maria", 30));
        Sistema.adicionarPaciente(new Paciente("Maiara", 31));
        Sistema.adicionarPaciente(new Paciente("Mirela", 32));
        Sistema.adicionarPaciente(new Paciente("Lucas", 33));
        Sistema.adicionarPaciente(new Paciente("Andrey", 34));
        Sistema.adicionarPaciente(new Paciente("Gustavo", 35));
        Sistema.adicionarPaciente(new Paciente("Sabrina", 36));
        Sistema.adicionarPaciente(new Paciente("Yasmin", 37));
        Sistema.adicionarPaciente(new Paciente("Silvana", 38));
        Sistema.adicionarPaciente(new Paciente("Adriana", 39));
        Sistema.adicionarPaciente(new Paciente("Ines", 40));
    }

    public static void examesIniciais() {
        Medico listaMedico[] = Sistema.getListaMedicos(); //pega todos os medicos guardados no sistema
        Paciente listaPaciente[] = Sistema.getListaPacientes(); //pega todos  os pacientes no sistema
        String listaDatas[] = {
                "01/01/2024",     //datas aleatorias
                "11/01/2024",
                "28/02/2024",
                "20/09/2024",
                "10/10/2024",
                "12/01/2024",
                "15/07/2024",
                "09/11/2024",
                "25/12/2024",
                "21/11/2024"
        };

        for (int i = 0; i < listaDatas.length; i++) { //coloca no sistema as autorizações
            Sistema.adicionarAutorizacao(new Autorizacao(listaMedico[i], listaMedico[i].getAreasAtuacao(), listaDatas[i], listaPaciente[i]));
        }

    }

    public static void printarListaAdministrador() { //Printa os administradores
        Administrador listaAdm[] = Sistema.getListaAdministrador();

        for (Administrador administrador : listaAdm) {
            System.out.println(administrador);
        }

    }

    public static Medico printarListaMedico() { //Printa os medicos e retorna o medico escolhido
        Medico listaMedico[] = Sistema.getListaMedicos();
        int index = -1;

        for (int i = 0; i < listaMedico.length; i++) {
            System.out.println((i + 1) + " - " + listaMedico[i] + "\n");
        }

        System.out.print("Digite: ");
        index = sc.nextInt();

        if (index > 0 && index < listaMedico.length) {
            return listaMedico[index - 1];
        } else {
            return null;
        }
    }

    public static AreasAtuacao printarListaAreasAtuacaoSemUso() { //Printa as areas de atuacao

        List<AreasAtuacao> listaNaoUsados = List.of(
                AreasAtuacao.PEDIATRIA,
                AreasAtuacao.RADIOLOGIA,
                AreasAtuacao.DERMATOLOGIA,
                AreasAtuacao.ENDOCRINOLOGIA,
                AreasAtuacao.GERIATRIA,
                AreasAtuacao.HEMATOLOGIA,
                AreasAtuacao.OFTALMOLOGIA,
                AreasAtuacao.PSIQUIATRIA,
                AreasAtuacao.UROLOGIA,
                AreasAtuacao.COLONOSCOPISTA,
                AreasAtuacao.GASTROENTELOGIA,
                AreasAtuacao.OTORRINOLARINGOLOGIA);

        int index = -1;

        do {
            System.out.println();
            System.out.println("Todas as Areas de atuacao: ");
            for (int i = 0; i < listaNaoUsados.size(); i++) {
                System.out.println((i + 1) + " - " + listaNaoUsados.get(i));
            }
            System.out.print("Digite: ");
            index = sc.nextInt();

            if (index < 0 || index > listaNaoUsados.size()) {
                System.out.println("Digite um numero Correto");
            }

        } while (index < 0 || index > listaNaoUsados.size());

        return listaNaoUsados.get(index - 1);
    }

    public static AreasAtuacao printarListaAreasAtuacao() { //Printa as areas de atuacao e retorna uma area escolhida

        List<AreasAtuacao> lista = List.of(
                AreasAtuacao.PEDIATRIA,
                AreasAtuacao.RADIOLOGIA,
                AreasAtuacao.DERMATOLOGIA,
                AreasAtuacao.ENDOCRINOLOGIA,
                AreasAtuacao.GERIATRIA,
                AreasAtuacao.HEMATOLOGIA,
                AreasAtuacao.OFTALMOLOGIA,
                AreasAtuacao.PSIQUIATRIA,
                AreasAtuacao.UROLOGIA,
                AreasAtuacao.COLONOSCOPISTA,
                AreasAtuacao.GASTROENTELOGIA,
                AreasAtuacao.OTORRINOLARINGOLOGIA);

        int index = -1;

        do {
            System.out.println();
            System.out.println("Todas as Areas de atuacao: ");
            for (int i = 0; i < lista.size(); i++) {
                System.out.println((i + 1) + " - " + lista.get(i));
            }
            System.out.print("Digite: ");
            index = sc.nextInt();

            if (index < 0 || index > lista.size()) {
                System.out.println("Digite um numero Correto");
            }

        } while (index < 0 || index > lista.size());

        return lista.get(index - 1);
    }

    public static Paciente printarListaPaciente() { //Printa os pacientes e retorna o paciente escolhido
        Paciente listaPacientes[] = Sistema.getListaPacientes();
        int index = -1;

        for (int i = 0; i < listaPacientes.length; i++) {
            System.out.println((i+1) + " - " + listaPacientes[i] + "\n");
        }

        System.out.print("Digite: ");
        index = sc.nextInt();

        if (index > 0 && index < listaPacientes.length) {
            return listaPacientes[index - 1];
        } else {
            return null;
        }

    }

    public static void menuContas() throws ParseException { //Menu principal
        int menu = 1;

        do {
            System.out.println();
            System.out.println("0 - Para sair");
            System.out.println("1 - Menu de Administrador");
            System.out.println("2 - Menu de Medico");
            System.out.println("3 - Menu de Paciente");
            System.out.print("Digite: ");
            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    escolherAdministrador();
                    break;
                case 2:
                    escolherMedico();
                    break;
                case 3:
                    escolherPaciente();
                    break;
            }

        } while (menu > 0 && menu < 4);

    }

    public static void escolherAdministrador() { //(função adiministrador) escolhe um adinistrador para iniciar o menu com ele
        Administrador lista[] = Sistema.getListaAdministrador();
        int index = -1;
        boolean idCerto = false;

        do {
            System.out.println();
            System.out.println("Escolha sua conta de Administrador: ");
            System.out.println();

            for (int i = 0; i < lista.length; i++) {
                System.out.println(lista[i]);
            }

            System.out.println();
            System.out.print("Digite o seu id: ");
            int id = sc.nextInt();

            for (int i = 0; i < lista.length; i++) {
                if (lista[i].getId() == id) {
                    idCerto = true;
                    index = i;
                    break;
                }
            }

            if (idCerto == false) {
                System.out.println("ID NÃO ENCONTRADO");
            }

        } while (idCerto == false);

        menuAdministrador(lista[index]);
    }

    public static void incluirUsuario(Administrador administrador) { //(função de adiministrador) inclui um novo usuario
        String nome;
        int menu = 1, id;
        boolean permitido = false;

        do {
            System.out.println("Qual usuario deseja incluir? ");
            System.out.println("1 - Medico");
            System.out.println("2 - Paciente");
            System.out.println("3 - Adiministrador");
            System.out.print("Digite: ");
            menu = sc.nextInt();
            System.out.println();

            switch (menu) {
                case 1:
                    AreasAtuacao areasAtuacao;
                    System.out.print("Digite um nome: (somente uma palavra)");
                    nome = sc.next();
                    System.out.print("Digite seu id: ");
                    id = sc.nextInt();
                    System.out.println("Qual das areas de atuacao? ");
                    System.out.println();
                    areasAtuacao = printarListaAreasAtuacaoSemUso();

                    permitido = administrador.adicionarMedico(new Medico(nome, id, areasAtuacao));

                    if (permitido == false) {
                        System.out.println("USUARIO NAO ADICIONADO = USUARIO OU ID JÁ EXISTENTE");
                    }
                    break;
                case 2:

                    System.out.print("Digite um nome: (somente uma palavra)");
                    nome = sc.next();
                    System.out.print("Digite seu id: ");
                    id = sc.nextInt();
                    permitido = administrador.adicionarPaciente(new Paciente(nome, id));

                    if (permitido == false) {
                        System.out.println("USUARIO NAO ADICIONADO = USUARIO OU ID JÁ EXISTENTE");
                    }

                    break;
                case 3:

                    System.out.print("Digite um nome: (somente uma palavra)");
                    nome = sc.next();
                    System.out.print("Digite seu id: ");
                    id = sc.nextInt();
                    permitido = administrador.adicionarAdministrador(new Administrador(nome, id));

                    if (permitido == false) {
                        System.out.println("USUARIO NAO ADICIONADO = USUARIO OU ID JÁ EXISTENTE");
                    }

                    break;

            }

        } while (menu < 1 || menu > 3);
    }

    public static void buscarUsuario(Administrador administrador) { //(função de adiministrador) busca um medico

        int menu;

        System.out.println("Qual?");
        System.out.println("1 - Medico");
        System.out.println("2 - Paciente");
        System.out.print("Digite: ");
        menu = sc.nextInt();

        if (menu == 1) {
            Medico medico = printarListaMedico();
            administrador.buscarMedico(medico);
        } else if (menu == 2) {
            Paciente paciente = printarListaPaciente();
            administrador.buscarPaciente(paciente);
        }

    }

    public static void menuAdministrador(Administrador administrador) { //(função de adiministrador) menu administrador
        int menu = 1;

        do {
            System.out.println();
            System.out.println("Ola, administrador " + administrador.getNome());
            System.out.println("0 - Para sair");
            System.out.println("1 - Incluir novo Usuario");
            System.out.println("2 - Buscar Medico ou Paciente");
            System.out.println("3 - Estatisticas Gerais");
            System.out.print("Digite um numero: ");
            menu = sc.nextInt();
            System.out.println();

            switch (menu) {
                case 1:
                    incluirUsuario(administrador);
                    menuAdministrador(administrador);
                    break;
                case 2:
                    buscarUsuario(administrador);
                    menuAdministrador(administrador);
                    break;
                case 3:
                    System.out.println();
                    administrador.EstatisticasGerais();
                    System.out.println();
                    menuAdministrador(administrador);
                    break;
            }

        } while (menu > 0 && menu < 4);
    }

    public static void escolherPaciente() throws ParseException { //(função paciente) escolhe um paciente e incia um menu com ele
        Paciente lista[] = Sistema.getListaPacientes();
        int index = -1;
        boolean idCerto = false;

        do {
            System.out.println();
            System.out.println("Escolha sua conta de Paciente: ");
            System.out.println();

            for (Paciente paciente : lista) {
                System.out.println(paciente);
            }

            System.out.print("Digite o seu id: ");
            int id = sc.nextInt();

            for (int i = 0; i < lista.length; i++) {
                if (lista[i].getId() == id) {
                    idCerto = true;
                    index = i;
                    break;
                }
            }

            if (idCerto == false) {
                System.out.println("ID NÃO ENCONTRADO");
            }

        } while (idCerto == false);

        menuPaciente(lista[index]);
    }

    private static void menuPaciente(Paciente paciente) throws ParseException { //(função paciente) menu paciente
        int menu = 1;

        do {
            System.out.println();
            System.out.println("Ola, paciente " + paciente.getNome());
            System.out.println("0 - Para sair");
            System.out.println("1 - Listar as suas Autorizações (ordenadas por data)");
            System.out.println("2 - Marcar um exame como conluido");
            System.out.println("3 - Modificar a data de um exame");
            System.out.print("Digite um numero: ");
            menu = sc.nextInt();
            System.out.println();

            switch (menu) {
                case 1:
                    System.out.println();
                    paciente.filtarAutorizacao();
                    System.out.println();
                    menuPaciente(paciente);
                    break;
                case 2:
                    int codigo;
                    System.out.println("Qual autorização: ");
                    paciente.filtarAutorizacao();
                    System.out.println("Digite o codigo: ");
                    codigo = sc.nextInt();
                    System.out.println("Qual data que foi concluida? (Formato=(dd/MM/yyyy))");
                    String data = sc.next();

                    if (data.length() != 10) {
                        System.out.println("FORMATO DD/MM/YYYYY ERRADO");
                    } else {
                        if (Sistema.VerficadorData(data, paciente)) {
                            paciente.concluirExame(codigo - 1);
                            paciente.dataDeConclusao(codigo - 1, data);
                        } else {
                            System.out.println("DATA 30 DIAS ANTES DE UMA AUTORIZACAO OU 30 DIAS DEPOIS");
                        }
                    }
                    menuPaciente(paciente);
                    break;
                case 3:
                    System.out.println("Qual autorização: ");
                    paciente.filtarAutorizacao();
                    System.out.println("Digite o codigo: ");
                    codigo = sc.nextInt();
                    System.out.println("Qual data que foi concluida? (Formato=(dd/MM/yyyy))");
                    data = sc.next();

                    Autorizacao lisAutorizacao[] = Sistema.getListaAutorizacao();

                    if (data.length() != 10) {
                        System.out.println("FORMATO DD/MM/YYYYY ERRADO");
                    } else {
                        if (Sistema.VerficadorData(data, paciente)) {
                            paciente.adicionarAutorizacao(new Autorizacao(lisAutorizacao[codigo - 1].getMedico(),
                                    lisAutorizacao[codigo - 1].getTipoDoExame(), data, paciente));
                        } else {
                            System.out.println("DATA 30 DIAS ANTES DE UMA AUTORIZACAO OU 30 DIAS DEPOIS");
                        }
                    }

                    menuPaciente(paciente);
                    break;
            }

        } while (menu > 0 && menu < 4);

    }

    public static void escolherMedico() throws ParseException {//(função medico) escolhe um médico e inicia o menu com ele 
        Medico lista[] = Sistema.getListaMedicos();
        int index = -1;
        boolean idCerto = false;

        do {
            System.out.println();
            System.out.println("Escolha sua conta de Medico: ");
            System.out.println();

            for (Medico medico : lista) {
                System.out.println(medico);
            }

            System.out.print("Digite o seu id: ");
            int id = sc.nextInt();

            for (int i = 0; i < lista.length; i++) {
                if (lista[i].getId() == id) {
                    idCerto = true;
                    index = i;
                    break;
                }
            }

            if (idCerto == false) {
                System.out.println("ID NÃO ENCONTRADO");
            }

        } while (idCerto == false);

        menuMedico(lista[index]);
    }

    private static void menuMedico(Medico medico) throws ParseException {//(função medico) menu medico
        int menu = 1;

        do {
            System.out.println();
            System.out.println("Ola, doutor " + medico.getNome());
            System.out.println("0 - Para sair");
            System.out.println("1 - Incluir uma nova autorização");
            System.out.println("2 - Listar as autorizacoes por Paciente");
            System.out.println("3 - Listar as autorizacoes por Tipo de Exame");
            System.out.print("Digite um numero: ");
            menu = sc.nextInt();
            System.out.println();

            switch (menu) {
                case 1:
                    System.out.println("Escolha um paciente ");
                    Paciente paciente = printarListaPaciente();
                    System.out.println("Qual data ? (Formato=(dd/MM/yyyy))");
                    String data = sc.next();

                    if (data.length() != 10) {
                        System.out.println("FORMATO DD/MM/YYYYY ERRADO");
                    } else {
                        if (Sistema.VerficadorData(data, paciente)) {
                            Sistema.adicionarAutorizacao(
                                    new Autorizacao(medico, medico.getAreasAtuacao(), data, paciente));
                        } else {
                            System.out.println("DATA 30 DIAS ANTES DE UMA AUTORIZACAO OU 30 DIAS DEPOIS");
                        }

                    }
                    menuMedico(medico);
                    break;
                case 2:
                    System.out.println("Escolha seu paciente");
                    Paciente paciente2 = printarListaPaciente();
                    System.out.println();
                    System.out.println("Lista de autorizacoes do paciente " + paciente2.getNome() + " por data");
                    medico.filtarPaciente(paciente2);
                    System.out.println();
                    menuMedico(medico);
                    break;
                case 3:
                    System.out.println("Escolha o tipo do exame:");
                    AreasAtuacao areasAtuacao = printarListaAreasAtuacao();
                    System.out.println();
                    System.out.println("Lista de autorizacoes de " + areasAtuacao + " por data");
                    medico.filtarTipoDeExame(areasAtuacao);
                    System.out.println();
                    menuMedico(medico);
                    break;
            }

        } while (menu > 0 && menu < 4);

    }

}
