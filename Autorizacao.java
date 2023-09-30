public class Autorizacao {
    private int codigo;
    private static int codigoGerador=1;
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
        return "  Codigo:  " + codigo + "  Medico:  " + medico + "  TipoDoExame:  " + tipoDoExame + "  Data: " + data + "  Paciente: " + paciente ;
    }


}
