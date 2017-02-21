package controle.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;

public class ControleFabricaDeConexao {
	
	public Connection getConnection() throws ClassNotFoundException, ServletException {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(
					 "jdbc:mysql://localhost/viewmaster", "sam", "123");
		}catch(SQLException e){
			throw new ServletException("Sem conexão com o banco de dados, "+e);
		}
		
	}
	
}
