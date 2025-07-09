/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelArthur;

/**
 *
 * @author arthu
 */
public class Pizza extends Categoria {
    private String ingredientes;

    public Pizza(String nome, double preco, String ingredientes) {
        super(nome, preco);
        this.ingredientes = ingredientes;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String getDescricaoCategoria() {
        return getNome() + " - " + ingredientes;
    }

    @Override
    public String toString() {
        return getNome() + " R$" + getPreco() + " | " + ingredientes + " | Qtd: " + quantidade;
    }
}