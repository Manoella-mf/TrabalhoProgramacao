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
public class ManterMusica {
     public void inserir(Connection mus, String data, String titulo, String album, boolean favoritada) {
				
		String sql = "INSERT INTO Musica(data, titulo, album, favoritada) VALUES (?,?,?,?)";

	    try {	    	
	        PreparedStatement stmt = mus.prepareStatement(sql);  
	        stmt.setString(1, data);  
	        stmt.setString(2, titulo);
                stmt.setString(3, album);
	        stmt.setBoolean(4, favoritada);
	        stmt.execute();  
	        stmt.close();  
	        //System.out.println("Dados inseridos com sucesso!");

	    } catch (SQLException e) {  
	            throw new RuntimeException("Aba não Preenchida ! " + e.getMessage() +sql);  
	    } 
		
	}
	
	public void alterar(Connection mus, String data, String titulo, String album, boolean favoritar) {
		
		String sql = "UPDATE musica "
				+ "set  data = ?, titulo = ?, album= ?"
				+ " where titulo = ?";

	    try {	    	
	        PreparedStatement stmt = mus.prepareStatement(sql);  
	        stmt.setString(1, data);  
	        stmt.setString(2, titulo);
	        stmt.setString(3, album);
                stmt.setBoolean(4, favoritar);
	        stmt.execute();  
	        stmt.close();  
	        System.out.println("Alteração feita com sucesso!");

	    } catch (SQLException e) {  
	            throw new RuntimeException("Erro com a  alteração! " + e.getMessage());  
	    } 
		
	}

	public void excluir(Connection mus, String titulo) { /// SOMENTE o ARTISTA
				
		String sql = "DELETE from Musica where titulo = " + titulo;
		try {
			PreparedStatement stmt = mus.prepareStatement(sql);
			int rs = stmt.executeUpdate();
			System.out.println("rs = " + rs);
			
			if (rs == 1) {
                System.out.println("Música excluido com sucesso....");              
            }else {
            	System.out.println("Música não encontrado na base de dados....");
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir Música!..." + e.getMessage());
        }
		    System.out.println("");
		 	
	}
	
	public void pesquisar(Connection mus, String titulo) {
		String sql = "Select * from Musica where titulo = " + titulo;
		try {
			PreparedStatement stmt = mus.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                System.out.println("Nome do Artista: " + rs.getInt("tipoConta"));
                System.out.println("data: " + rs.getString("data"));
                System.out.println("titulo: " + rs.getString("titulo"));
                System.out.println("Album: " + rs.getString("Album"));
                System.out.println("Favoritado: " + rs.getString("favoritar"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao selecionar Música!..." + e.getMessage());
        }
		    System.out.println("");
		 	
		
	}
        
        public ArrayList<String> listarMusica(Connection con) {
            ArrayList<String> titulos = new ArrayList<>();
		String sql = "Select * from musica";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                            titulos.add( rs.getString("titulo"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao selecionar album!..." + e.getMessage());
        }
		    System.out.println("");
        return titulos;	
	}
        
                public ArrayList<String> listarMusicaFav(Connection con) {
            ArrayList<String> titulos = new ArrayList<>();
		String sql = "Select * from musica where favoritada = true";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                            titulos.add( rs.getString("titulo"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao selecionar album!..." + e.getMessage());
        }
		    System.out.println("");
        return titulos;	
	}
        
        
        public void favoritar(Connection con, String titulo, boolean favoritar) {
		System.out.println(favoritar);
		String sql = "UPDATE musica "
				+ "set favoritada = ? "
				+ " where titulo = ?";

	    try {	    	
	        PreparedStatement stmt = con.prepareStatement(sql);
	        stmt.setBoolean(1, false);
                stmt.setString(2, titulo);
	        stmt.execute();  
	        stmt.close();  
	        System.out.println("Alteração feita com sucesso!");

	    } catch (SQLException e) {  
	            throw new RuntimeException("Erro com ao favoritar! " + e.getMessage() + sql);  
	    } 
		
	}
}
