package ModelArthur;
import java.time.LocalDate;
import ModelLuidgi.Cliente;

/**
 * @author arthu
 */
public class Avaliacao {

    private String texto;
    private LocalDate data;
    private Cliente cliente;
    private static Avaliacao avaliacaoSalvaGlobal;

    public Avaliacao(Cliente cliente, String texto, LocalDate data) {
        this.cliente = cliente;
        this.texto = texto;
        this.data = data;
    }

    public String getTexto() {
        return texto;
    }

    public LocalDate getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public String getNomeCliente() {
        return cliente.getNome();
}

    // Getter e setter estáticos
    public static Avaliacao getAvaliacaoSalvaGlobal() {
        return avaliacaoSalvaGlobal;
    }

    public static void setAvaliacaoSalvaGlobal(Avaliacao avaliacao) {
        avaliacaoSalvaGlobal = avaliacao;
    }
}