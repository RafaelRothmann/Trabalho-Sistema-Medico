import java.text.ParseException;

public class Paciente extends Usuario {

    public Paciente(String nome, int id) {
        super(nome, id);
    }

    public boolean adicionarAutorizacao(Autorizacao autorizacao) throws ParseException {

        if (Sistema.VerficadorData(autorizacao.getData(), this)) { 
            //vai verificar se a data é 30 dias antes ou depois de uma autorizacao

            Sistema.adicionarAutorizacao(autorizacao);
            return true;
            //vai adicionar a Autorizacao ao array de autorizacoes, ""Banco de dados"" do programa
        }

        return false;
    }

    public boolean modificarAutorizacao(Autorizacao autorizacaoAntiga, Autorizacao autorizacaoNova){
        Sistema.removerAutorizacao(autorizacaoAntiga);
        // remove a autorizacao antiga no banco de dados

        if(VerficadorData(autorizacaoNova.getData(), this)){ // verifica a data
            Sistema.adicionarAutorizacao(autorizacaoNova); //adiciona a nova autorizacao
            return true;
        } else {
            Sistema.adicionarAutorizacao(autorizacaoAntiga); //adiciona a autorizacao antiga de volta
            return false;
        }
    }

    private boolean VerficadorData(String data, Paciente paciente) {
        return false;
    }

    public void filtarAutorizacao(){
        Autorizacao listaSolicitacao[] = Sistema.getListaAutorizacao();
        
        for (int i = 0; i < listaSolicitacao.length; i++) {
            if(listaSolicitacao[i].getPaciente() == this){ 
            System.out.println(listaSolicitacao[i]); //mostra todas as autorizacoes do paciente
            }
        }
    }

}