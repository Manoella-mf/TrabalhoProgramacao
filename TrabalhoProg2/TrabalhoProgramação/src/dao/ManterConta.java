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

/**
 *
 * @author manu
 */
public class ManterConta {
    
    static int codigo;
   
    public void inserir(Connection con, String nome, String senha, String email, String cpf, int tipoConta) {
				
		String sql = "INSERT INTO Conta(nome, senha, email, cpf, tipoConta) VALUES (?,?,?,?,?)";

	    try {	    	
	        PreparedStatement stmt = con.prepareStatement(sql);  
	        stmt.setString(1, nome);
	        stmt.setString(2, senha);  
	        stmt.setString(3, email);
                stmt.setString(4, cpf);
	        stmt.setInt(5, tipoConta);
	        stmt.execute();  
	        stmt.close();  
	        //System.out.println("Conta inserida com sucesso!");

	    } catch (SQLException e) {  
	            throw new RuntimeException("Erro ao inserir Conta! " + e.getMessage());  
	    } 
		
            if(tipoConta == 1){
                sql = "INSERT INTO artista(artista) VALUES (?)";

                try {
                    PreparedStatement stmt = con.prepareStatement(sql);
                    codigo = buscaConta(con, email, senha);
                    stmt.setInt(1, codigo);
                    stmt.execute();  
                    stmt.close();  
                    //System.out.println("Conta inserida com sucesso!");

                } catch (SQLException e) {  
                        throw new RuntimeException("Erro ao inserir artista! " + e.getMessage());  
                } 
            }else{
                    sql = "INSERT INTO ouvinte(ouvinte) VALUES (?)";

                try {
                    PreparedStatement stmt = con.prepareStatement(sql);
                    codigo = buscaConta(con, email, senha);
                    stmt.setInt(1, codigo);
                    stmt.execute();  
                    stmt.close();  
                    //System.out.println("Conta inserida com sucesso!");

                } catch (SQLException e) {  
                        throw new RuntimeException("Erro ao inserir ouvinte! " + e.getMessage());  
                } 
            }
	}
	
	public void alterar(Connection con, String nome, String senha, String email, String cpf, int tipoConta) {
		
		String sql = "UPDATE Conta "
				+ "set nome = ?, senha = ?, email = ?"
				+ " where cpf = ?";

	    try {	    	
	        PreparedStatement stmt = con.prepareStatement(sql);  
	        stmt.setString(1, nome);  
	        stmt.setString(2, senha);
	        stmt.setString(3, email);
                stmt.setString(4, cpf);
	        stmt.setInt(5, tipoConta);
	        stmt.execute();  
	        stmt.close();  
	        System.out.println("Conta alterado com sucesso!");

	    } catch (SQLException e) {  
	            throw new RuntimeException("Erro ao alterar Conta! " + e.getMessage());  
	    } 
		
	}

	public void excluirConta(Connection con, String cpf) {
				
		String sql = "DELETE from Conta where cpf = " + cpf;
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			int rs = stmt.executeUpdate();
			System.out.println("rs = " + rs);
			
			if (rs == 1) {
                System.out.println("Conta excluida com sucesso....");              
            }else {
            	System.out.println("Conta não encontrada na base de dados....");
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir Conta!..." + e.getMessage());
        }
		    System.out.println("");
		 	
	}
	
	public boolean pesquisar(Connection con, String email, String senha) {
		String sql = "Select * from Conta where email = '" + email + "' and senha = '" + senha + "'";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.executeQuery();
			ResultSet rs = stmt.getResultSet();
                        
                return rs.next();
            //}
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao selecionar conta!..." + e.getMessage() + sql);
        }
            //return false;
	}
        
        public int buscaTipoConta(Connection con, int codigo) {
		String sql = "Select tipoConta from Conta where codigo = " + codigo;
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                        
                return rs.getInt("tipoConta");
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar tipo conta!..." + e.getMessage() + sql);
        }
            return 0;
	}
        
        public String buscaNomeConta(Connection con, int codigo) {
		String sql = "Select nome from Conta where codigo = " + codigo;
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                        
			//while (rs.next()) {
                
                /*System.out.println("CPF: " + rs.getString("cpf"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("E-mail: " + rs.getString("email"));
                System.out.println("Senha: " + rs.getString("senha"));*/
                return rs.getString("nome");
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar tipo conta!..." + e.getMessage() + sql);
        }
            return null;
	}
        
        public int buscaConta(Connection con, String email, String senha) {
		String sql = "Select codigo from Conta where email = '" + email + "' and senha = '" + senha + "'";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                  return rs.getInt("codigo");
                //System.out.println(sql + rs.toString());
                /*System.out.println("CPF: " + rs.getString("cpf"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("E-mail: " + rs.getString("email"));
                System.out.println("Senha: " + rs.getString("senha"));*/
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar conta!..." + e.getMessage() + sql);
        }
            //return ;
        return 0;
	}
}
