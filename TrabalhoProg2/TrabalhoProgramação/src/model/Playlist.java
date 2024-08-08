/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author manu
 */
public class Playlist implements Serializable{
    //private int qtdFaixa;// este é uma dado calculado, que muda quando as músicas da playlist mudam
    private String nome;
    private Musica musica;
    static int codigo;

    public Playlist(String nome) {
       // this.qtdFaixa = 0;
        this.nome = nome;
        this.musica = musica;
    }

   
    /*public int getQtdFaixa() {
        return qtdFaixa;
    }

    public void setQtdFaixa(int qtdFaixa) {
        this.qtdFaixa = qtdFaixa;
    }
*/
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
    }
    
    
    @Override
    public String toString() {
        return "Playlist: " + nome; //+ qtdFaixa;
    }
    
    
}
