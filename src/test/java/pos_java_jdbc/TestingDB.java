package pos_java_jdbc;

import static org.junit.Assert.*;

import java.sql.PreparedStatement;
import java.util.List;

import org.junit.Test;

import conexao_jdbc.SingleConnection;
import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.UserPosJava;

public class TestingDB {
	
	

	/**
	 * Objetivo: add um registro
	 */
	@Test
	public void initBanco() {
		UserPosDAO userDAO = new UserPosDAO();
		UserPosJava userJava= new UserPosJava();
		
		
		userJava.setNome("Kimberle lee ");
		userJava.setEmail("Silikimber@gmail.com");
		userDAO.salvar(userJava);
//		System.out.println("Usuario Salvo");
		
	}
	
	
	
	
	
	
	
	
	

}
