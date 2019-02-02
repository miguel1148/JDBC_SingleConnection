package pos_java_jdbc;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.UserPosDAO;
import model.BeanUserFone;

public class TesteInnerJoin {

	/**
	 * Objetivo: Fazer Innerjoin com as tabelas userposjava, tefoneuser 
	 */
	
	@Test
	public void listarUserFones() {
		UserPosDAO dao = new UserPosDAO();
		List<BeanUserFone> beanUserFones = dao.listaUserFone(4L);
		
		for(BeanUserFone buf : beanUserFones) {
			System.out.println(buf);
			System.out.println("--------------------------------------");
		}
	}
}
