/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author manu
 */
public class Mensagem {
    private String mensagem;

    public Mensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public String msgCadastroSucesso(){
        this.mensagem = "Cadastro realizado com sucesso!";
        return this.mensagem;
    }
    public String msgSalvoSucesso(){
        this.mensagem = "Alterações salvas com sucesso!";
        return this.mensagem;
    }
    public String msgExcluirSucesso(){
        this.mensagem = "Exclusão realizada com sucesso!";
        return this.mensagem;
    }
    public String msgErroInfo(){
        this.mensagem = "Preencha todos os campos!";
        return this.mensagem;
    }
    
    public String msgErroSelecionado(){
        this.mensagem = "Nenhuma opção selecionada!";
        return this.mensagem;
    }
    
    public String msgFavoritar(){
        this.mensagem = "Adicionado aos favoritos!";
        return this.mensagem;
    }
    public String msgDesfavoritar(){
        this.mensagem = "Removido dos favoritos!";
        return this.mensagem;
    }
}
