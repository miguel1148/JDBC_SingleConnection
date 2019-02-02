package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import conexao_jdbc.SingleConnection;
import model.BeanUserFone;
import model.Telefone;
import model.UserPosJava;

public class UserPosDAO {

	private Connection connection;
	
	
	public UserPosDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(UserPosJava userJava) {
		
		try {
			String sql = "insert into userposjava ( nome, email) values(?,?)";
			//Responsavel por fazer o "INSERT" no banco
			PreparedStatement insert = connection.prepareStatement(sql);//Prepara o sql
			//INJETANDO OS VALORES
//			insert.setLong(1, userJava.getId());//  ele insere no primeiro valor "id" ele insere **String sql = "insert into userposjava ( nome, email) values(?,?,?)";
			insert.setString(1, userJava.getNome());//settando o nome
			insert.setString(2, userJava.getEmail());
			insert.execute();
			connection.commit();//salva no banco
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @return BUSCA UM REGISTRO ESPECIFICO
	 * @throws Exception
	 */
	public UserPosJava buscar(Long id) throws Exception{
		UserPosJava retorno = new UserPosJava();

		String sql = "select * from userposjava where id = "+ id;//Montamos o nosso 'sql'	
	
		PreparedStatement statement =  connection.prepareStatement(sql);//PASSANDO O SQL PARA O OBJETO 'PreparedStatement'
		ResultSet resultado = statement.executeQuery();//Execução no banco de dados
		
		while(resultado.next()) {
			retorno.setId(resultado.getLong("id"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setEmail(resultado.getString("email"));
			
		}
		
		return retorno;
	}
	
	/**
	 * @return TODOS OS REGISTROS DO BANCO
	 * @throws Exception
	 */
	public List<UserPosJava> listar() throws Exception{
		List<UserPosJava> list = new ArrayList<UserPosJava>();

		String sql = "select * from userposjava";//Montamos o nosso 'sql'	
	
		PreparedStatement statement =  connection.prepareStatement(sql);//PASSANDO O SQL PARA O OBJETO 'PreparedStatement'
		ResultSet resultado = statement.executeQuery();//Execução no banco de dados
		
		while(resultado.next()) {
			UserPosJava userPos = new UserPosJava();
			userPos.setId(resultado.getLong("id"));
			userPos.setNome(resultado.getString("nome"));
			userPos.setEmail(resultado.getString("email"));
			
			list.add(userPos);
		}
		
		return list;
	}
	
	
	
	public void atualizar(UserPosJava userJava) {
		String sql = "update userposjava set nome = ? where id = " + userJava.getId();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, userJava.getNome());
			
			statement.execute();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
	
	public void deletar(Long id) {
		try {
			
			String sql = "delete from userposjava where id = " + id;
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			preparedstatement.execute();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}
		
	}
	
	//Deletar usuarios que são referenciados em telefones
	public void deleteUsersREF(Long idUser) {
		
		try {
			String sqlFone ="delete from telefoneuser where usuariopessoa = "+ idUser;
			String sqlUser = "delete from userposjava where id = "+ idUser;
			
			PreparedStatement preparedstatement = connection.prepareStatement(sqlFone);
			preparedstatement.executeUpdate();
			connection.commit();
			
			preparedstatement = connection.prepareStatement(sqlUser);
			preparedstatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} 
	}
	
//*****************TELEFONE*******************
	public void salvarTelefone(Telefone telefone) {
		
		String sql =  "insert into telefoneuser(numero, tipo, usuariopessoa) values(?, ?, ?)";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, telefone.getNumero());
			statement.setString(2, telefone.getTipo());
			statement.setLong(3, telefone.getUsuario());
			statement.execute();
			connection.commit();
			
			
		} catch (SQLException e) {
			try {
				connection.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public List<BeanUserFone> listaUserFone(Long idUser){
		
		List<BeanUserFone> beanUserFones = new ArrayList<BeanUserFone>();
		String sql = "select nome, numero, email from telefoneuser as fone "
				+ "inner join userposjava as userp "
				+ "on fone.usuariopessoa = userp.id "
				+ "where userp.id = " + idUser;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				BeanUserFone userFone = new BeanUserFone();
				
				userFone.setEmail(resultSet.getString("email"));
				userFone.setNome(resultSet.getString("nome"));
				userFone.setNumero(resultSet.getString("numero"));
				
				beanUserFones.add(userFone);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return beanUserFones;
		
	}
	
	
	
	
}
