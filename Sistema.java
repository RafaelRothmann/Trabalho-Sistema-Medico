import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class Sistema {
    private static List<Autorizacao> ListaAutorizacao = new ArrayList<Autorizacao>();
    private static List<Medico> ListaMedico = new ArrayList<Medico>();
    private static List<Paciente> ListaPaciente = new ArrayList<Paciente>();
    private static List<Administrador> ListaAdministrador = new ArrayList<Administrador>();

    public static boolean VerficadorData(String data, Paciente paciente) throws ParseException {

        for (int i = 0; i < ListaAutorizacao.size(); i++) {
            if (ListaAutorizacao.get(i).getPaciente() == paciente) {

                String dataString = ListaAutorizacao.get(i).getData();

                LocalDate dataAutorizacao = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                LocalDate dataNova = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                LocalDate trintaDiasDepois = dataAutorizacao.plusDays(30);
                LocalDate trintaDiasAntes = dataAutorizacao.minusDays(30);

                if (trintaDiasDepois.isAfter(dataNova) && dataAutorizacao.isBefore(dataNova)) { // verifica se é 30 dias depois
                    return false;
                }
        
                if (trintaDiasAntes.isBefore(dataNova) && dataAutorizacao.isAfter(dataNova)) { // verifica se é 30 dias antes
                    return false;
                }
        
                if (dataNova.isEqual(trintaDiasAntes) || dataNova.isEqual(trintaDiasDepois)|| dataNova.isEqual(dataAutorizacao)) { // verifica se as datas sao iguais
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean adicionarAutorizacao(Autorizacao autorizacao) {
        for (int i = 0; i < ListaAutorizacao.size(); i++) {
            if (ListaAutorizacao.get(i).getTipoDoExame() == autorizacao.getTipoDoExame()) {
                return false;
            }
        }

        adicionarMedico(autorizacao.getMedico());
        adicionarPaciente(autorizacao.getPaciente());
        ListaAutorizacao.add(autorizacao);
        return true;
    }

    public static boolean adicionarMedico(Medico medico) {

        for (int i = 0; i < ListaAutorizacao.size(); i++) {
            if (ListaAutorizacao.get(i).getMedico().equals(medico)) {
                return false;
            }
        }

        for (int i = 0; i < ListaMedico.size(); i++) {
            if (ListaMedico.get(i).equals(medico) || ListaMedico.get(i).getId() == medico.getId()) {
                return false;
            }
        }

        ListaMedico.add(medico);
        return true;
    }

    public static boolean adicionarPaciente(Paciente paciente) {

        for (int i = 0; i < ListaAutorizacao.size(); i++) {
            if (ListaAutorizacao.get(i).getPaciente().equals(paciente)) {
                return false;
            }
        }

        for (int i = 0; i < ListaPaciente.size(); i++) {
            if (ListaPaciente.get(i).equals(paciente) || ListaPaciente.get(i).getId() == paciente.getId()) {
                return false;
            }
        }

        ListaPaciente.add(paciente);
        return true;
    }

    public static boolean adicionarAdministrador(Administrador administrador) {

        for (int i = 0; i < ListaAdministrador.size(); i++) {
            if (ListaAdministrador.get(i).equals(administrador) || ListaAdministrador.get(i).getId() == administrador.getId()) {
                return false;
            }
        }

        ListaAdministrador.add(administrador);
        return true;
    }

    public static void removerAutorizacao(Autorizacao autorizacao) {
        for (int i = 0; i < ListaAutorizacao.size(); i++) {
            if (ListaAutorizacao.get(i) == autorizacao) {
                ListaAutorizacao.remove(i);
            }
        }
    }

    public static void setEstado(int index, Estado estado) {
        ListaAutorizacao.get(index).setEstado(estado);
    }

    public static void setDataFinalizada(int index, String data){
        ListaAutorizacao.get(index).setDataFinalizado(data);
    }

    public static Autorizacao[] getListaAutorizacao() {
        Autorizacao lista[] = new Autorizacao[ListaAutorizacao.size()];

        for (int i = 0; i < lista.length; i++) {
            lista[i] = ListaAutorizacao.get(i);
        }

        return lista;
    }

    public static Medico[] getListaMedicos() {
        Medico lista[] = new Medico[ListaAutorizacao.size()];

        for (int i = 0; i < lista.length; i++) {
            lista[i] = ListaMedico.get(i);
        }

        return lista;
    }

    public static Paciente[] getListaPacientes() {
        Paciente lista[] = new Paciente[ListaAutorizacao.size()];

        for (int i = 0; i < lista.length; i++) {
            lista[i] = ListaPaciente.get(i);
        }

        return lista;
    }

    public static Administrador[] getListaAdministrador() {
        Administrador lista[] = new Administrador[ListaAutorizacao.size()];

        for (int i = 0; i < lista.length; i++) {
            lista[i] = ListaAdministrador.get(i);
        }

        return lista;
    }
}
