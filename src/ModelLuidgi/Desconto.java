/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelLuidgi;

/**
 *
 * @author luidgivarela
 */
public class Desconto {
    // Valor mínimo para frete grátis
    private static final double valor_minimo_para_frete_gratis = 50.0;

    // Desconto para quem opta pela modalidade expressa (ex: 10%)
    private static final double desconto_expressa = 0.10;
  
    /**
     * Calcula o valor do frete com base na modalidade e subtotal.
     * Se for delivery e subtotal >= 50, o frete é grátis.
     */
    public static double calcularFrete(String modalidade, double subtotal) {
        if (modalidade.equalsIgnoreCase("delivery") && subtotal >= valor_minimo_para_frete_gratis) {
            return 0.0;
        }
        // Exemplo: frete padrão é 5 reais
        return modalidade.equalsIgnoreCase("delivery") ? 5.0 : 0.0;
    }

    /**
     * Aplica desconto se a modalidade for expressa.
     */
    public static double aplicarDesconto(String modalidade, double subtotal) {
        if (modalidade.equalsIgnoreCase("expressa")) {
            return subtotal * desconto_expressa;
        }
        return 0.0;
    }
}
