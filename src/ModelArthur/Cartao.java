
package ModelArthur;
import javax.swing.JOptionPane;

/**
 *
 * @author arthu
 */
public class Cartao extends Pagamento {

    private String numero;
    private String validade;
    private String codigo;
    private String tipo;
    private String nomeTitular;
    private static Cartao cartaoPadrao = null; // atributo estático

    // Construtor com valor (usado para cálculo)
    public Cartao(double valor) {
        super(valor);
    }
    
    // Construtor padrão (para quando o valor não for necessário ainda)
    public Cartao() {
        super(0.0); 
}

    @Override
    public double calcularValorFinal() {
        return valor; // sem desconto
    }
    
    @Override
    public void confirmarPagamento() {
        JOptionPane.showMessageDialog(null, 
            "💳 Pagamento com cartão confirmado!\nTotal: R$ " + calcularValorFinal(), 
            "Confirmação", 
            JOptionPane.INFORMATION_MESSAGE);
    }

    // Setters
    public void setNumeroCartao(String numero) {
        this.numero = numero;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public void setCodigoSeguranca(String codigo) {
        this.codigo = codigo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }
    
    public static void setCartaoPadrao(Cartao cartao) {
        cartaoPadrao = cartao;
}

    // Getters
    public String getNumeroCartao() {
        return numero;
    }

    public String getValidade() {
        return validade;
    }

    public String getCodigoSeguranca() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }
    
    public static Cartao getCartaoPadrao() {
        return cartaoPadrao;
    }
}