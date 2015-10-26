package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AeronaveController;
import controller.AeroportoController;
import model.AeronaveModel;
import model.AeronaveModelView;
import model.AeroportoModel;
import model.TipoAeronaveModel;

/**
 * Servlet implementation class AeronaveServlet
 */
@WebServlet(name = "AeronaveServlet", urlPatterns = {"/AeronaveServlet"})
public class AeronaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AeronaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		verificaRota(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verificaRota(request, response);
	}
	
	private void verificaRota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String url = request.getParameter("url");
		
		if(url == null)
			listagem(request, response);
			
		if (url.equals("list"))
			listagem(request, response);
		else if (url.equals("exibeEdit"))
			exibeEdit(request, response);
		else if (url.equals("edit"))
			editar(request, response);
		else if (url.equals("delete"))
			excluir(request, response);
		else if (url.equals("exibeAdd"))
			exibeAdd(request, response);
		else if (url.equals("add"))
			add(request, response);
		else
			listagem(request, response);
	}
	
	private void listagem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		ArrayList<AeronaveModelView> lista = new AeronaveController().listarTodosAmv();
		
		request.setAttribute("lista", lista);
		
		RequestDispatcher view = request
				.getRequestDispatcher("/AeronaveList.jsp");
		view.forward(request, response);
	}
	
	private void editar (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{	
		AeronaveModel aero = new AeronaveModel();
		
		aero.setIdAeronave(Integer.parseInt(request.getParameter("id")));
		aero.setIdTipo(Integer.parseInt(request.getParameter("tipo")));
		aero.setNome(request.getParameter("nome"));
		aero.setQtdAssentos(Integer.parseInt(request.getParameter("assentos")));
		aero.setFileira(Integer.parseInt(request.getParameter("fileira")));
		aero.setColuna(Integer.parseInt(request.getParameter("coluna")));

		if(!new AeronaveController().editarAeronve(aero))
		{
			request.setAttribute("msg",
					"<div class='btn btn-warning'>Falha ao Cadastrar!</div>");

			RequestDispatcher view = request
					.getRequestDispatcher("/AeronaveEdit.jsp");
			try {
				view.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			RequestDispatcher view = request
					.getRequestDispatcher("/AeronaveServlet?url=list");
			try {
				view.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void exibeEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ArrayList<TipoAeronaveModel> listaTipo = new AeronaveController().listarTipoTodos();
		AeronaveModelView amv = new AeronaveController().buscarAmvId(Integer.parseInt(request.getParameter("id")));
		
		request.setAttribute("listaTipo", listaTipo);
		request.setAttribute("amv", amv);
		
		RequestDispatcher view = request
				.getRequestDispatcher("/AeronaveEdit.jsp");
		
		view.forward(request, response);
	}
	
	private void excluir (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		
		if(!new AeronaveController().removerAeronave(id))
		{
			request.setAttribute("msg",
					"<div class='btn btn-warning'>Falha ao Cadastrar!</div>");

			RequestDispatcher view = request
					.getRequestDispatcher("/AeronaveServlet?url=list");
			try {
				view.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			RequestDispatcher view = request
					.getRequestDispatcher("/AeronaveServlet?url=list");
			try {
				view.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void add(HttpServletRequest request, HttpServletResponse response){
		AeronaveModel aero = new AeronaveModel();
		
		aero.setIdTipo(Integer.parseInt(request.getParameter("tipo")));
		aero.setNome(request.getParameter("nome"));
		aero.setQtdAssentos(Integer.parseInt(request.getParameter("assentos")));
		aero.setFileira(Integer.parseInt(request.getParameter("fileira")));
		aero.setColuna(Integer.parseInt(request.getParameter("coluna")));

		if(!new AeronaveController().cadastrarAeronave(aero))
		{
			request.setAttribute("msg",
					"<div class='btn btn-warning'>Falha ao Cadastrar!</div>");

			RequestDispatcher view = request
					.getRequestDispatcher("/AeronaveAdd.jsp");
			try {
				view.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			RequestDispatcher view = request
					.getRequestDispatcher("/AeronaveServlet?url=list");
			try {
				view.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
	
	public void exibeAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ArrayList<TipoAeronaveModel> listaTipo = new AeronaveController().listarTipoTodos();
		
		request.setAttribute("listaTipo", listaTipo);
		
		RequestDispatcher view = request
				.getRequestDispatcher("/AeronaveAdd.jsp");
		view.forward(request, response);
	}
}
