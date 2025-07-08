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
    private int quantidade;

    public Pizza(String nome, double preco, String ingredientes) {
        super(nome, preco);
        this.ingredientes = ingredientes;
        this.quantidade = 0; // começa com 0
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void incrementar() {
        this.quantidade++;
    }

    public void decrementar() {
        if (this.quantidade > 0) {
            this.quantidade--;
        }
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