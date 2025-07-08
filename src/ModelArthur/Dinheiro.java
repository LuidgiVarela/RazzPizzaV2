/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelArthur;
import javax.swing.JOptionPane;

/**
 *
 * @author arthu
 */
public class Dinheiro extends Pagamento {
    public Dinheiro(double valor) {
        super(valor);
    }

    @Override
    public double calcularValorFinal() {
        return valor * 0.90; // 10% de desconto
    }
     @Override
    public void confirmarPagamento() {
        JOptionPane.showMessageDialog(null, 
           "💵 Pagamento em Dinheiro confirmado!\nTotal com desconto: R$ " + calcularValorFinal(),
            "Confirmação", 
            JOptionPane.INFORMATION_MESSAGE);
    }
}