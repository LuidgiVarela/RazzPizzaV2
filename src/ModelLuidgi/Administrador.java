/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelLuidgi;

/**
 *
 * @author luidgivarela
 */
public class Administrador extends Usuario {

    public Administrador(String nome, String email, String senha, String telefone) {
        super(nome, email, senha, telefone);
    }

    @Override
    public String getTipo() {
        return "Administrador";
    }
}
