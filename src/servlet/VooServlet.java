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
import controller.VooController;
import model.AeronaveModel;
import model.AeronaveModelView;
import model.AeroportoModel;
import model.TipoAeronaveModel;
import model.VooModel;
import model.VooModelView;

/**
 * Servlet implementation class AeronaveServlet
 */
@WebServlet(name = "VooServlet", urlPatterns = {"/VooServlet"})
public class VooServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VooServlet() {
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
		
		ArrayList<VooModelView> lista = new VooController().listarTodosAmv();
		
		request.setAttribute("lista", lista);
		
		RequestDispatcher view = request
				.getRequestDispatcher("/VooList.jsp");
		view.forward(request, response);
	}
	
	private void editar (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{	
		VooModel voo = new VooModel();
		
		voo.setIdVoo(Integer.parseInt(request.getParameter("id")));
		voo.setIdOrigem(Integer.parseInt(request.getParameter("origem")));
		voo.setIdDestino(Integer.parseInt(request.getParameter("destino")));
		voo.setIdAeronave(Integer.parseInt(request.getParameter("aeronave")));
		//voo.setData("2015-10-12 15:51:00");
		voo.setStatus(request.getParameter("status"));
		voo.setPreco(Double.parseDouble(request.getParameter("valor")));

		if(!new VooController().editarVoo(voo))
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
					.getRequestDispatcher("/VooServlet?url=list");
			try {
				view.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void exibeEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ArrayList<AeroportoModel> listaAerop = new AeroportoController().listarTodos();
		ArrayList<AeronaveModelView> listaAero = new AeronaveController().listarTodosAmv();
		VooModelView vmv = new VooController().buscarVmvId(Integer.parseInt(request.getParameter("id")));
		
		request.setAttribute("listaAerop", listaAerop);
		request.setAttribute("listaAero", listaAero);
		request.setAttribute("vmv", vmv);
		
		RequestDispatcher view = request
				.getRequestDispatcher("/VooEdit.jsp");
		view.forward(request, response);
	}
	
	private void excluir (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		
		if(!new VooController().removerVoo(id))
		{
			request.setAttribute("msg",
					"<div class='btn btn-warning'>Falha ao Cadastrar!</div>");

			RequestDispatcher view = request
					.getRequestDispatcher("/VooServlet?url=list");
			try {
				view.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			RequestDispatcher view = request
					.getRequestDispatcher("/VooServlet?url=list");
			try {
				view.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void add(HttpServletRequest request, HttpServletResponse response){
		VooModel voo = new VooModel();
		
		voo.setIdOrigem(Integer.parseInt(request.getParameter("origem")));
		voo.setIdDestino(Integer.parseInt(request.getParameter("destino")));
		voo.setIdAeronave(Integer.parseInt(request.getParameter("aeronave")));
		//voo.setData("2015-10-12 15:51:00");
		voo.setStatus(request.getParameter("status"));
		voo.setPreco(Double.parseDouble(request.getParameter("valor")));

		if(!new VooController().cadastrarVoo(voo))
		{
			request.setAttribute("msg",
					"<div class='btn btn-warning'>Falha ao Cadastrar!</div>");

			RequestDispatcher view = request
					.getRequestDispatcher("/VooAdd.jsp");
			try {
				view.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			RequestDispatcher view = request
					.getRequestDispatcher("/VooServlet?url=list");
			try {
				view.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
	
	public void exibeAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ArrayList<AeroportoModel> listaAerop = new AeroportoController().listarTodos();
		ArrayList<AeronaveModelView> listaAero = new AeronaveController().listarTodosAmv();
		
		request.setAttribute("listaAerop", listaAerop);
		request.setAttribute("listaAero", listaAero);
		
		RequestDispatcher view = request
				.getRequestDispatcher("/VooAdd.jsp");
		view.forward(request, response);
	}
}
