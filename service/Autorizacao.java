package service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import entities.*;

public class Autorizacao implements Comparable<Autorizacao> {
    private static int codigoGerador = 1;
    private int codigo;
    private Medico medico;
    private AreasAtuacao tipoDoExame;
    private String data;
    private Paciente paciente;
    private Estado estado;
    private String dataFinalizada;

    public Autorizacao(Medico medico, AreasAtuacao tipoDoExame, String data, Paciente paciente) {
        this.medico = medico;
        this.tipoDoExame = tipoDoExame;
        this.data = data;
        this.paciente = paciente;
        this.estado = Estado.NAOREALIZADO;
        codigo = codigoGerador;
        codigoGerador++;
    }

    public int getCodigo() {
        return codigo;
    }

    public Medico getMedico() {
        return medico;
    }

    public AreasAtuacao getTipoDoExame() {
        return tipoDoExame;
    }

    public String getData() {
        return data;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getEstado() {
        if (estado.equals(Estado.REALIZADO)) {
            return "Realizado";
        } else {
            return "Nao Realizado";
        }
    }

    public String getDataFinalizado() {
        return dataFinalizada;
    }

    public void setDataFinalizado(String dataFinalizado) {
        this.dataFinalizada = dataFinalizado;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Autorizacao other = (Autorizacao) obj;
        if (codigo != other.codigo)
            return false;
        if (medico == null) {
            if (other.medico != null)
                return false;
        } else if (!medico.equals(other.medico))
            return false;
        if (tipoDoExame != other.tipoDoExame)
            return false;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (paciente == null) {
            if (other.paciente != null)
                return false;
        } else if (!paciente.equals(other.paciente))
            return false;
        if (estado != other.estado)
            return false;
        if (dataFinalizada == null) {
            if (other.dataFinalizada != null)
                return false;
        } else if (!dataFinalizada.equals(other.dataFinalizada))
            return false;
        return true;
    }

    @Override
    public int compareTo(Autorizacao outro) {
        LocalDate dateEsse = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate dataOutro = LocalDate.parse(outro.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return dataOutro.compareTo(dateEsse);
    }

    @Override
    public String toString() {
        String msg = "Codigo: " + codigo +
                "\nMedico = " + medico +
                "\nTipoDoExame: " + tipoDoExame +
                "\nData: " + data +
                "\nPaciente = " + paciente +
                "\nEstado: " + getEstado();

        return msg;
    }
}