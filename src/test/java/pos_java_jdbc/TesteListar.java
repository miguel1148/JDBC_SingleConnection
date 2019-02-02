package pos_java_jdbc;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.UserPosDAO;
import model.UserPosJava;

public class TesteListar {
	
	/**
	 * Objetivo: Listar todos os registros do banco de dados
	 */

	@Test
	public void initListar() {
		UserPosDAO dao = new UserPosDAO();
		System.err.println("--------------------------------------------------\n\n");
			try {
				List<UserPosJava> list = dao.listar();
				for(UserPosJava userJava : list) {
					System.out.println("/n" + userJava);
					System.out.println("----------------------------------------------------------------\n");
				}
					
				}catch(Exception e){
		
				}

		
			}		

}

