/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author manu
 */
public class ManterPlaylist {
    public void inserir(Connection play, String nome, int codigo) { /// Musica musica
				
		String sql = "INSERT INTO Playlist(nome, ouvinte) VALUES (?,?)";

	    try {	    	
	        PreparedStatement stmt = play.prepareStatement(sql);  
	        stmt.setString(1, nome);
	        stmt.setInt(2, codigo);
                
	        stmt.execute();  
	        stmt.close();  
	        //System.out.println("Playlist inserida com sucesso!");

	    } catch (SQLException e) {  
	            throw new RuntimeException("Erro ao inserir Playlist! " + e.getMessage());  
	    } 
		
	}
	
	public void alterar(Connection play,  String nome, String musica) {
		
		String sql = "UPDATE Playlist "
				+ "nome = ?, musica = ?"
				+ " where nome = " + nome ;

	    try {	    	
	        PreparedStatement stmt = play.prepareStatement(sql);  
	        //stmt.setInt(1, qntFaixa);  
	        stmt.setString(2, nome);
	        stmt.setString(3, musica);
                
	        stmt.execute();  
	        stmt.close();  
	        System.out.println("Playlist alterado com sucesso!");

	    } catch (SQLException e) {  
	            throw new RuntimeException("Erro ao alterar Playlist! " + e.getMessage());  
	    } 
		
	}

	public void excluirPlaylist(Connection play, String nome) { 
				
		String sql = "DELETE from Playlist where nome = " +  nome;
		try {
			PreparedStatement stmt = play.prepareStatement(sql);
			int rs = stmt.executeUpdate();
			System.out.println("rs = " + rs);
			
			if (rs == 1) {
                System.out.println("Playlist excluida com sucesso....");              
            }else {
            	System.out.println("Playlist não encontrada na base de dados....");
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir a Playlist!..." + e.getMessage());
        }
		    System.out.println("");
		 	
	}
	
	public void pesquisar(Connection play, String nome) {
		String sql = "Select * from Playlist where nome = " + nome;
		try {
			PreparedStatement stmt = play.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                //System.out.println("Quantidade de Faixa " + rs.getInt("qntFaixa"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Música: " + rs.getString("musica"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao selecionar Playlist!..." + e.getMessage());
        }
		    System.out.println("");
		 	
		
	}
        
        public ArrayList<String> listarPlaylist(Connection con) {
            ArrayList<String> titulos = new ArrayList<>();
		String sql = "Select * from playlist";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                    titulos.add( rs.getString("nome"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao selecionar album!..." + e.getMessage());
        }
		    System.out.println("");
        return titulos;
		 	
		
	}
        
        public void inserirMusica(Connection play, String musica, int codigo) { /// Musica musica
				
		String sql = "INSERT INTO playlist_musica(musica, codigo) VALUES (?,?)";

	    try {	    	
	        PreparedStatement stmt = play.prepareStatement(sql);  
	        stmt.setString(1, musica);  
	        stmt.setInt(2, codigo);
                
	        stmt.execute();  
	        stmt.close();  
	        System.out.println("Playlist inserida com sucesso!" + sql);
                 
	    } catch (SQLException e) {  
	            throw new RuntimeException("Erro ao inserir Playlist! " + e.getMessage() + sql);  
	    } 
		
	}
        
        public int buscaPlaylist(Connection con, String nome) {
		String sql = "Select codigo from playlist where nome = '" + nome + "'";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                  return rs.getInt("codigo");
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar playlist!..." + e.getMessage() + sql);
        }
            //return ;
        return 0;
	}
}
