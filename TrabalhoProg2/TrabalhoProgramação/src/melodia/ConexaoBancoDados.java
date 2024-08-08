package melodia;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBancoDados {
	public Connection getConexaoAcesso() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection ("jdbc:postgresql://localhost:5432/Melodia","postgres","postgres");
			System.out.println("BANCO CONECTADO......: " + con.toString());
			
			return con;
			
		}catch (Exception e) {
			System.out.println("Erro ao conectar o banco: " + e.getMessage());
		}
		
		return null;
	}

    Connection close() throws CloneNotSupportedException {
        clone();
            return null;
    }
    
}
