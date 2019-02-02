package pos_java_jdbc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.UserPosDAO;

public class TesteDeletar {

	/**
	 * Objetivo: Deletar um registro  
	 */
	
	@Test
	public void initDeletar() {
		try {
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(10L);
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		
	}

}
