/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelArthur;

/**
 *
 * @author arthu
 */
public abstract class Categoria {
    private String nome;
    private double preco;
    private int quantidade;

    public Categoria(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public void incrementar(){
        this.quantidade+=1;
    }
    
    public void decrementar(){
        if(this.quantidade > 0) this.quantidade-=1;
        
    }

    public abstract String getDescricaoCategoria();

    @Override
    public String toString() {
        return nome + " - R$" + preco;
    }
}