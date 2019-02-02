package pos_java_jdbc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.UserPosDAO;
import model.Telefone;

public class TesteInsertTelefone {

	/**
	 * Objetivo: Inserir telefones no banco
	 */
	
	@Test
	public void insertTelefone() {
		Telefone telefone = new Telefone();
		telefone.setNumero("(88) 3665-2429");
		telefone.setTipo("CASA");
		telefone.setUsuario(8L);
		
		UserPosDAO dao = new UserPosDAO();
		dao.salvarTelefone(telefone);
		
		
	}

}
