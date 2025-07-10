package ModelLuidgi;

import ModelArthur.Cartao;
import java.time.LocalDate;
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
    private Cartao cartaoSalvo; 
    private LocalDate dataCadastro;
    
    public Cliente(String nome, String email, String telefone, String cep, String senha, String numero) {
        super(nome, email, senha, telefone); // inicializa os atributos da superclasse
        this.telefone = telefone;
        this.cep = cep;
        this.numero = numero; // número da residência
        this.dataCadastro = LocalDate.now();
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
    
    public Cartao getCartaoSalvo() {
        return cartaoSalvo;
    }

    public void setCartaoSalvo(Cartao cartaoSalvo) {
        this.cartaoSalvo = cartaoSalvo;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    
    @Override
    public String getTipo() {
        return "Cliente";
    }
    
}



