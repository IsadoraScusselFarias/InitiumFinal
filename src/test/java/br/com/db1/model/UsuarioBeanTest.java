/*package br.com.db1.model;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.faces.context.FacesContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.db1.AbstractTestCase;
import br.com.db1.controller.UsuarioBean;
import br.com.db1.dao.impl.UsuarioDao;
import br.com.db1.model.Usuario;

//@RunWith(PowerMockRunner.class)
//@PrepareForTest({ FacesContext.class })
public class UsuarioBeanTest extends AbstractTestCase {

	@Mock
	private UsuarioBean bean;
	@Mock
	private UsuarioDao dao;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		dao = new UsuarioDao(manager);
		bean = new UsuarioBean(dao);
	}

	@Test
	public void initTest() {
		bean.init();
		Assert.assertTrue(bean.getList().size() == 0);

		Usuario usuario = new Usuario();
		usuario.setNome("TT");
		bean.getList().add(usuario);
		Assert.assertTrue(bean.getList().size() == 1);

		bean.init();
		Assert.assertTrue(bean.getList().size() == 0);

	}

	@Test
	public void novoTest() {
		Assert.assertEquals("cadastrarUsuario", bean.novo());

	}

	@Test
	@Ignore
	public void salvarTest() {
		FacesContext facesContext = mock(FacesContext.class);
		when(FacesContext.getCurrentInstance()).thenReturn(facesContext);
		    
		Usuario usuario = new Usuario();
		usuario.setNome("TT");
		bean.setUsuario(usuario);
		when(bean.salvar());
		Assert.assertEquals("usuario", bean.salvar());
		Assert.assertTrue(bean.getList().size() == 1);
		Assert.assertEquals("TT", bean.getNomeUsuarioFiltrada());

	}

}*/