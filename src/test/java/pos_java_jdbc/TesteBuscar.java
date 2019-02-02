package pos_java_jdbc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.UserPosDAO;
import model.UserPosJava;

public class TesteBuscar {

	/**
	 * @author MiguelRamalho
	 * Objetivo: Buscar um registro no banco de daods
	 * 
	 */
	@Test
	public void initBuscar() throws Exception {
		UserPosDAO dao = new UserPosDAO();
		UserPosJava userJava = dao.buscar( 4L);
		System.out.println(userJava);
	}
}
