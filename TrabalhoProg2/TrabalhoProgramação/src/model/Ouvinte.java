/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author manu
 */
public class Ouvinte extends Conta{

    public Ouvinte(String playlist, String nome, String senha, String email, String cpf, int tipoConta) {
        super(nome, senha, email ,cpf, tipoConta);
    }

    @Override
    public String toString() {
        return "Ouvinte";
    }
    
}
