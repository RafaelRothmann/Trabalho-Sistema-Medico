import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class Sistema {
    private static List<Autorizacao> ListaAutorizacao = new ArrayList<Autorizacao>();

    public static boolean VerficadorData(String data, Paciente paciente) throws ParseException {

        for (int i = 0; i < ListaAutorizacao.size(); i++) {
            if (ListaAutorizacao.get(i).getPaciente() == paciente) {

                String dataString = ListaAutorizacao.get(i).getData();
                
                LocalDate dataAutorizacao = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                LocalDate dataNova = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                LocalDate trintaDiasDepois = dataAutorizacao.plusDays(30);
                LocalDate trintaDiasAntes = dataAutorizacao.minusDays(30);

                if(trintaDiasDepois.isBefore(dataNova) && dataAutorizacao.isAfter(dataNova)){ // verifica se é 30 dias depois
                    return false;
                }

                if(trintaDiasAntes.isAfter(dataNova) && dataAutorizacao.isBefore(dataNova)){ // verifica se é 30 dias antes
                    return false;
                }

                if(dataNova.isEqual(trintaDiasAntes) || dataNova.isEqual(trintaDiasDepois) || dataNova.isEqual(dataAutorizacao)){ //verifica se as datas sao iguais
                    return false;
                }
            } 
        }

        return true;
    }

    public static void adicionarAutorizacao(Autorizacao autorizacao) {
        ListaAutorizacao.add(autorizacao);
    }

    public static void removerAutorizacao(Autorizacao autorizacao) {
        for (int i = 0; i < ListaAutorizacao.size(); i++) {
            if(ListaAutorizacao.get(i) == autorizacao){
                ListaAutorizacao.remove(i);
            }
        }
    }

    public static Autorizacao[] getListaAutorizacao() {
        Autorizacao lista[] = new Autorizacao[ListaAutorizacao.size()];

        for (int i = 0; i < lista.length; i++) {
            lista[i] = ListaAutorizacao.get(i);
        }

        return lista;
    }


}
