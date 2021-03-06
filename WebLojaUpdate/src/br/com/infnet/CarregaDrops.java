package br.com.infnet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import br.com.infnet.dao.AtributoDAO;
import br.com.infnet.dao.LojaDAO;
import br.com.infnet.enums.TipoMoto;
import br.com.infnet.model.Atributo;
import br.com.infnet.model.Loja;

/**
 * Servlet implementation class CarregaDrops
 */
public class CarregaDrops extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarregaDrops() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Comecou");

		try {
			AtributoDAO atributoDAO = new AtributoDAO();
			List<Atributo> atributosCarro = atributoDAO.GetAtributosPorTipo(1);

			br.com.infnet.enums.Tipo[] tipos = br.com.infnet.enums.Tipo.values();

			List<String> tiposCarro = new ArrayList<String>();
			List<String> appendTipos = new ArrayList<String>();

			for (br.com.infnet.enums.Tipo tipo : tipos) {
				tiposCarro.add(tipo.toString());
				appendTipos.add(tipo.toString());
			}

			TipoMoto[] tiposMoto = TipoMoto.values();

			List<String> listTiposMoto = new ArrayList<String>();

			for (TipoMoto tipom : tiposMoto) {
				listTiposMoto.add(tipom.toString());
				appendTipos.add(tipom.toString().toUpperCase());
			}
			
			getServletContext().setAttribute("tiposCarro", tiposCarro);
			getServletContext().setAttribute("atributosCarro",atributosCarro);
			
			
			LojaDAO ldao = new LojaDAO();

			List<Loja> lojas = ldao.listar();
			getServletContext().setAttribute("lojas", lojas);
			System.out.println("teste");

		} catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (SQLException e1) {
			System.out.println(e1);
		}

	}
	
}
