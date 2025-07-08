package ModelLuidgi;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author luidgivarela
 */


// import model.CartaoSalvo; // Descomente quando a classe CartaoSalvo estiver disponível



public class Cliente extends Usuario {
    private String cep;
    private String numero;
    // private CartaoSalvo cartaoSalvo; 

    public Cliente(String nome, String email, String telefone, String cep, String senha, String numero) {
        super(nome, email, senha, telefone); // inicializa os atributos da superclasse
        this.telefone = telefone;
        this.cep = cep;
        this.numero = numero; // número da residência
    }

    // Métodos get/set dos novos atributos
  
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String getTipo() {
        return "Cliente";
    }
    
}



