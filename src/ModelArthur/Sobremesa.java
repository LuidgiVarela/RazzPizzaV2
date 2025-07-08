/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelArthur;

/**
 *
 * @author arthu
 */
public class Sobremesa extends Categoria {
    public Sobremesa(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public String getDescricaoCategoria() {
        return "Sobremesa: " + getNome();
    }
}