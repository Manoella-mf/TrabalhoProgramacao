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
public class ManterAlbum {
    public void inserir(Connection alb, int artista, String data, String titulo, String genero, boolean favoritar) {
				
		String sql = "INSERT INTO Album(artista, data, titulo, genero, favoritar) VALUES (?,?,?,?,?)";

	    try {	    	
	        PreparedStatement stmt = alb.prepareStatement(sql);  
	        stmt.setInt(1,artista);
	        stmt.setString(2, data);  
	        stmt.setString(3, titulo);
                stmt.setString(4, genero);
	        stmt.setBoolean(5, favoritar);
	        stmt.execute();  
	        stmt.close();  
	        //System.out.println("Dados inseridos com sucesso!");

	    } catch (SQLException e) {  
	            throw new RuntimeException("Album não Preenchido! " + e.getMessage());  
	    } 
		
	}
	
	public void alterar(Connection alb, int artista, String data, String titulo, String genero, boolean favoritar) {
		
		String sql = "UPDATE album "
				+ "set artista = ?, data = ?, titulo = ?, genero = ?"
				+ " where titulo = ?";

	    try {	    	
	        PreparedStatement stmt = alb.prepareStatement(sql);  
	        stmt.setInt(1, artista);  
	        stmt.setString(2, data);
	        stmt.setString(3, titulo);
                stmt.setString(4, genero);
	        stmt.setBoolean(5, favoritar);
	        stmt.execute();  
	        stmt.close();  
	        System.out.println("Alteração feita com sucesso!");

	    } catch (SQLException e) {  
	            throw new RuntimeException("Erro com a  alteração! " + e.getMessage());  
	    } 
		
	}
        
        public void favoritar(Connection alb, String titulo, boolean favoritar) {
		System.out.println(favoritar);
		String sql = "UPDATE album "
				+ "set favoritar = ? "
				+ " where titulo = ?";

	    try {	    	
	        PreparedStatement stmt = alb.prepareStatement(sql);
	        stmt.setBoolean(1, false);
                stmt.setString(2, titulo);
	        stmt.execute();  
	        stmt.close();  
	        System.out.println("Alteração feita com sucesso!");

	    } catch (SQLException e) {  
	            throw new RuntimeException("Erro com ao favoritar! " + e.getMessage() + sql);  
	    } 
		
	}

	public void excluir(Connection alb, String titulo) { 
				
		String sql = "DELETE from Album where titulo = " + titulo;
		try {
			PreparedStatement stmt = alb.prepareStatement(sql);
			int rs = stmt.executeUpdate();
			System.out.println("rs = " + rs);
			
			if (rs == 1) {
                System.out.println("Album excluido com sucesso....");              
            }else {
            	System.out.println("Album não encontrado na base de dados....");
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir Album!..." + e.getMessage());
        }
		    System.out.println("");
		 	
	}
	
	public void pesquisar(Connection alb, String titulo) {
		String sql = "Select * from Album where titulo = " + titulo;
		try {
			PreparedStatement stmt = alb.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                System.out.println("data: " + rs.getString("data"));
                System.out.println("titulo: " + rs.getString("titulo"));
                System.out.println("genero: " + rs.getString("genero"));
                System.out.println("Favoritado: " + rs.getString("favoritar"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao selecionar album!..." + e.getMessage());
        }
		    System.out.println("");
		 	
		
	}
        
        public ArrayList<String> listarAlbum(Connection alb) {
            ArrayList<String> titulos = new ArrayList<>();
		String sql = "Select * from Album";
		try {
			PreparedStatement stmt = alb.prepareStatement(sql);
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
        
        public ArrayList<String> listarAlbumFav(Connection alb) {
            ArrayList<String> titulos = new ArrayList<>();
		String sql = "Select * from Album where favoritar = true";
		try {
			PreparedStatement stmt = alb.prepareStatement(sql);
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
        
        public ArrayList<String> listarAlbumArt(Connection alb, int codigo) {
            ArrayList<String> titulos = new ArrayList<>();
		String sql = "Select * from Album where artista = " + codigo;
		try {
			PreparedStatement stmt = alb.prepareStatement(sql);
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
}
