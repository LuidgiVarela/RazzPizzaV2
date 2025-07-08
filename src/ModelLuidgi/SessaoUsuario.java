/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelLuidgi;
import ModelLuidgi.UsuarioLogado;

/**
 *
 * @author luidgivarela
 */
public class SessaoUsuario implements UsuarioLogado {
    
    private static SessaoUsuario instancia; 
    private Usuario clienteLogado; // aceita qualquer objeto do tipo Usuario, incluindo entregador ou cliente
    private String modalidadePedido; // modalidade do pedido

    private SessaoUsuario() {
        // Construtor privado para impedir instâncias externas
    }

    public static SessaoUsuario getInstancia() {
        if (instancia == null) {
            instancia = new SessaoUsuario();
        }
        return instancia;
    }

    @Override
    public  void setUsuarioLogado(Usuario cliente) {
        clienteLogado = cliente;
    }

    @Override
    public Usuario getUsuarioLogado() {
        return clienteLogado;
    }
    
    public void setModalidadePedido(String modalidade) {
        this.modalidadePedido = modalidade;
    }

    public String getModalidadePedido() {
        return this.modalidadePedido;
    }
}
