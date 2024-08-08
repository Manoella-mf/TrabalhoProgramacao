/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package melodia;

import java.sql.Connection;
//import dao.ManterAluno;
/**
 *
 * @author manu
 */
public class Principal {

    private static Connection con = null;
	
    public static void main(String[] args) {
    					
		ConexaoBancoDados conexao = new ConexaoBancoDados();
		
		try {
			con = conexao.getConexaoAcesso();
		}catch (Exception e) {
			System.out.println("Erro ao conectar o banco de dados: " + e.getMessage());
		}
		
		encerrarConexao();
	}
    public static void encerrarConexao() {
		try {
			con.close();
			System.out.println("Conexão com o Banco foi encerrada.....");
		}catch (Exception e) {
			System.out.println("Erro ao fechar a conexão: " + e.getMessage());
		}						
	}
}
