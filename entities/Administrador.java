package entities;

import service.*;

public class Administrador extends Usuario {

    public Administrador(String nome, int id) {
        super(nome, id);
    }

    public void EstatisticasGerais() {
        System.out.println("Numero de Medicos: " + numeroDeMedicos());
        System.out.println("Numero de Pacientes: " + numeroDePacientes());
        System.out.println("Numero de Autorizacoes: " + numeroDeAutorizacoes());
        System.out.println("Percentual de autorizacoes Realizados: " + percentualDeAutorizacoesRealizadas() + "%");
    }

    public boolean adicionarMedico(Medico medico) {
        return Sistema.adicionarMedico(medico);
    }

    public boolean adicionarPaciente(Paciente paciente) {
        return Sistema.adicionarPaciente(paciente);
    }

    public boolean adicionarAdministrador(Administrador administrador) {
        return Sistema.adicionarAdministrador(administrador);
    }

    public void buscarMedico(Medico medico) {
        Autorizacao lista[] = Sistema.getListaAutorizacao();

        System.out.println();

        for (int i = 0; i < lista.length; i++) {
            if (lista[i].getMedico().equals(medico)) {
                System.out.println(lista[i] + "\n");
            }
        }
    }

    public void buscarPaciente(Paciente paciente) {
        Autorizacao lista[] = Sistema.getListaAutorizacao();

        System.out.println();

        for (int i = 0; i < lista.length; i++) {
            if (lista[i].getPaciente().equals(paciente)) {
                System.out.println(lista[i] + "\n");
            }
        }
    }

    public int numeroDeMedicos() {
        return Sistema.getListaMedicos().length;
    }

    private int numeroDeAutorizacoes() {
        return Sistema.getListaAutorizacao().length;
    }

    private int numeroDePacientes() {
        return Sistema.getListaPacientes().length;
    }

    public double percentualDeAutorizacoesRealizadas() {
        Autorizacao lista[] = Sistema.getListaAutorizacao();
        double percentual = 0;

        for (int i = 0; i < lista.length; i++) {
            if (lista[i].getEstado().equals(Estado.REALIZADO)) {
                percentual++;
            }
        }

        return ((percentual * 100) / lista.length);
    }
}
