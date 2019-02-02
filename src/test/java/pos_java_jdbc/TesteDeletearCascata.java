package pos_java_jdbc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.UserPosDAO;

public class TesteDeletearCascata {

	/**
	 * Objetivo: Deleta usuarios referenciados pela entidade telefone
	 * Passos: Deletar primeiro a entidade filha(telefone) posteriormente o registro userposjava
	 */
	
	@Test
	public void deleteFoneNuser() {
		UserPosDAO dao = new UserPosDAO();
		dao.deleteUsersREF(11L);
	}
	
	
}
