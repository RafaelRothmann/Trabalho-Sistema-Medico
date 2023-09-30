import java.util.Arrays;

public class Medico extends Usuario {
    private AreasAtuacao areasAtuacao;

    public Medico (String nome, int id, AreasAtuacao areasAtuacao){
        super(nome, id);
        this.areasAtuacao = areasAtuacao;
    }

    public AreasAtuacao getAreasAtuacao() {
        return areasAtuacao;
    }

    public void filtarPaciente(Paciente paciente){
        Autorizacao lista[] = Sistema.getListaAutorizacao();

        Arrays.sort(lista);

        for (int i = 0; i < lista.length; i++) {
            if(lista[i].getPaciente() == paciente){
                System.out.println(lista[i]);
            }
        }
    }

    public void filtarTipoDeExame(AreasAtuacao tipoDeExame){
        Autorizacao lista[] = Sistema.getListaAutorizacao();
        
        Arrays.sort(lista);

        for (int i = 0; i < lista.length; i++) {
            if(lista[i].getTipoDoExame() == tipoDeExame){
                System.out.println(lista[i]);
            }
        }
    }

    public String toString(){
        return super.toString() + 
        ", Area de Atuacao: " + areasAtuacao;
    }
}