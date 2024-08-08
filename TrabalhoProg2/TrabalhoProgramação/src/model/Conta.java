/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author manu
 */
public class Conta { 
    private String nome;
    private String senha;
    private String email;
    private String cpf;
    private int tipoConta;

    public Conta(String nome, String senha, String email, String cpf, int tipoConta) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.cpf = cpf;
        this.tipoConta = tipoConta; //1 - Artista | 2 - Ouvinte
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }
    
    @Override
    public String toString() {
        String tipo = "";
        if(tipoConta == 1){
            tipo = "Artista";
        }else{
            tipo = "Ouvinte";
        }
        return "CPF: " + cpf +"\nNome: " + nome + "\nE-mail: " + email + "\nTipo de conta: " + tipo;
    }

    
}
