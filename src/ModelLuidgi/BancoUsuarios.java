package ModelLuidgi;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author luidgivarela
 */
import ModelLuidgi.Cliente;
import java.util.ArrayList;

public class BancoUsuarios {
    public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public static void adicionarUsuario(Usuario u) {
        listaUsuarios.add(u);
    }

    public static Usuario buscarPorEmail(String email) {
        for (Usuario u : listaUsuarios) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }
        }
        return null;
    }

    public static boolean autenticar(String email, String senha) {
        Usuario u = buscarPorEmail(email);
        return u != null && u.getSenha().equals(senha);
    }

    public static ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
}
