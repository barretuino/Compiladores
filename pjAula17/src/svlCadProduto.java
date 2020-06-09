import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/svlCadProduto")
public class svlCadProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<String> listagem = new ArrayList<String>();
       
    public svlCadProduto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = "{codigo: '" + request.getParameter("codigo") +
					   "',endereco: '" + request.getParameter("endereco") + "',"
					   	+ "quantidade: '" + request.getParameter("quantidade") + "'}";
		listagem.add(json);

		response.getWriter().append(listagem.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Executado doPost");
	}

}
