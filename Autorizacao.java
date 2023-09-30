import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Autorizacao implements Comparable<Autorizacao> {
    private static int codigoGerador = 1;
    private int codigo;
    private Medico medico;
    private AreasAtuacao tipoDoExame;
    private String data;
    private Paciente paciente;

    public Autorizacao(Medico medico, AreasAtuacao tipoDoExame, String data, Paciente paciente) {
        this.medico = medico;
        this.tipoDoExame = tipoDoExame;
        this.data = data;
        this.paciente = paciente;
        codigo=codigoGerador;
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

    @Override
    public String toString() {
        return "Codigo: " + codigo + ", Medico: " + medico + ", TipoDoExame: " + tipoDoExame + ", Data: " + data
        + ", Paciente: " + paciente;
    }

    @Override
    public int compareTo(Autorizacao outro) {
        LocalDate dateEsse = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
        LocalDate dataOutro = LocalDate.parse(outro.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return dateEsse.compareTo(dataOutro);
    }
}