package ModelArthur;
import java.time.LocalDate;

/**
 * @author arthu
 */
public class Avaliacao {

    // Texto da avaliação
    private String texto;

    // Nome do cliente que fez a avaliação
    private String nomeCliente;

    // Data da avaliação
    private LocalDate data;
    
    //email do cliente
    private String email;

    // Atributo estático que armazena a última avaliação feita (globalmente acessível)
    private static Avaliacao avaliacaoSalvaGlobal;

    // Construtor 
    public Avaliacao(String nomeCliente, String email, String texto, LocalDate data) {
        this.nomeCliente = nomeCliente;
        this.email = email;
        this.texto = texto;
        this.data = data;
    }

   
    // Getters
    public String getTexto() {
        return texto;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public LocalDate getData() {
        return data;
    }
    
    public String getEmail() {
        return email;
}


    // Getter estático para acessar a última avaliação salva globalmente
    public static Avaliacao getAvaliacaoSalvaGlobal() {
        return avaliacaoSalvaGlobal;
    }

    // Setter estático para definir uma nova avaliação global
    public static void setAvaliacaoSalvaGlobal(Avaliacao avaliacao) {
        avaliacaoSalvaGlobal = avaliacao;
    }
}