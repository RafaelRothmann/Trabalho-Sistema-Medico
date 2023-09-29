
/**
 * Escreva uma descrição da classe Paciente aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
import java.util.Date;

class Paciente {
    private String nome;
    // Outros atributos e métodos relevantes para um paciente

    public Paciente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Autorizacao {
    private Paciente paciente;
    private Date data;

    public Autorizacao(Paciente paciente, Date data) {
        this.paciente = paciente;
        this.data = data;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Date getData() {
        return data;
    }
}

