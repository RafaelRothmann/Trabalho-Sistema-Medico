import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int compareTo(Autorizacao outro) {
        LocalDate dateEsse = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate dataOutro = LocalDate.parse(outro.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return dateEsse.compareTo(dataOutro);
    }

    @Override
    public String toString() {
        String msg = "Codigo: " + codigo + ", Medico = " + medico + ", TipoDoExame: " + tipoDoExame + ", Data: " + data
        + ", Paciente = " + paciente + ", Estado: " + getEstado();

        if (estado.equals(Estado.REALIZADO)) {
            msg += ", Data do Exame: " + dataFinalizada;
        }

        return msg;
    }
}