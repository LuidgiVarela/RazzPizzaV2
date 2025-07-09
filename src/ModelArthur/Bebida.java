/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelArthur;

/**
 *
 * @author arthu
 */
public class Bebida extends Categoria {

    public static Object get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public Bebida(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public String getDescricaoCategoria() {
        return "Bebida: " + getNome();
    }
}
