package pos_java_jdbc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.UserPosDAO;
import model.UserPosJava;

public class TesteAtualizar {

/**
 * Objetivo: Atualizar um registro	
 */
		
	@Test
	public void initAtualizar() {
		
		
		try {
			UserPosDAO dao = new UserPosDAO();
			UserPosJava obj = dao.buscar(11L);
			obj.setNome("Kimberle Kane");
			dao.atualizar(obj);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
