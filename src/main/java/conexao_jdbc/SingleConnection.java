package conexao_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnection {

	private static String url = "jdbc:postgresql://localhost:5432/pos_java";// posjava é o nome do banco de dados
	private static String password = "admin";// senha do pgadmin
	private static String user = "postgres";// usuario do pgadmin
	private static Connection connection = null;
	
	static {
		conectar();
	}
	
	
	
	/**
	 * sempre de qualquer lugar que for invocado o singleConnetion ele chamará o conectar
	 */
	public SingleConnection() {
		conectar();
	}
	
	
	private static void conectar() {
		try {
			/**
			 * A conexão deve ser feita uma vez só e mantida
			 * as seções serão abertas e fechadas depois
			 */
			if(connection == null) {
				
				Class.forName("org.postgresql.Driver");//carregando o driver que será usado
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);//impede que seja salvo automaticamente. Eu decido qnd insert, update etc serão salvas
				System.err.println("Conexão Realizada com Sucesso");
			}
			
		} catch (Exception e) {
			try {
				connection.rollback();// ROOLBACK() reverte a operação
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());
		}
		
	}
	
	//Retorna a conexão
	// por isso deve ser public
	public static Connection getConnection() {
		return connection;
	}
	
}
