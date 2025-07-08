/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelLuidgi;

/**
 *
 * @author luidgivarela
 */
public class Entregador extends Usuario {
    private String cpf;
    private String cnh;

    public Entregador(String nome, String email, String senha, String telefone, String cpf, String cnh) {
        super(nome, email, senha, telefone);
        this.cpf = cpf;
        this.cnh = cnh;
    }

    public Entregador() {
        super(); // chama o construtor da classe Usuario, se necessário
    }
    
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getCnh() { return cnh; }
    public void setCnh(String cnh) { this.cnh = cnh; }

    @Override
    public String getTipo() {
        return "Entregador";
    }
}
