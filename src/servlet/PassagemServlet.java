package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AeronaveModelView;
import model.AeroportoModel;
import model.PassageiroModel;
import model.PassagemModel;
import model.Rel_Pass_Passg;
import model.VooModel;
import model.VooModelView;
import controller.AeronaveController;
import controller.AeroportoController;
import controller.PassageiroController;
import controller.PassagemController;
import controller.VooController;

/**
 * Servlet implementation class PassagemServlet
 */
@WebServlet("/PassagemServlet")
public class PassagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassagemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			
		if (url.equals("exibeAdd"))
			exibeAdd(request, response);
		else if (url.equals("add"))
			add(request, response);
		else if(url.equals("buscarPassagem"))
			buscarPassagem(request, response);
		else if(url.equals("checkin"))
			checkin(request, response);
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
		
		response.setContentType("text/html");
 
		Enumeration en = request.getParameterNames();
		String texto = "";
		
		ArrayList<PassageiroModel> listPassg = new ArrayList<PassageiroModel>();
		ArrayList<Rel_Pass_Passg> listRel = new ArrayList<Rel_Pass_Passg>();
		PassagemModel pass = new PassagemModel();
		PassageiroModel passg = new PassageiroModel();
		boolean valid = false;
		
		while(en.hasMoreElements())
		{
			Object objOri=en.nextElement();
			String param=(String)objOri;
			String value=request.getParameter(param);
			
			if(valid == false){
				if(param.equals("email"))
					pass.setEmail(value);
				else if(param.equals("celular"))
					pass.setCelular(value);
				else if(param.equals("voo")){
					pass.setIdVoo(Integer.parseInt(value));
					valid = true;
				}	
			}
			
			if((param).substring(1).equals("nome"))
				passg.setNome(value);
			else if((param).substring(1).equals("sobrenome"))
				passg.setSobrenome(value);
			else if((param).substring(1).equals("tratamento"))
				passg.setTratamento(value);
			else if((param).substring(1).equals("tipo")){
				passg.setTipo(value);
				listPassg.add(passg);
				passg = new PassageiroModel();
			}
		}
		
		PassagemController passCont = new PassagemController();
		pass.setStatus("Pendente");
		passCont.cadastrarPassagem(pass);
		int idPass = passCont.buscarUltimoId();
		
		for(PassageiroModel passTemp : listPassg){
			PassageiroController passgCont = new PassageiroController();
			passgCont.cadastrarPassageiro(passTemp);
			int idPassg = passgCont.buscarUltimoId();
			
			Rel_Pass_Passg rel = new Rel_Pass_Passg();
			rel.setPassageiro(idPassg);
			rel.setPassagem(idPass);
			listRel.add(rel);
		}
				
		new PassagemController().cadastrarRel(listRel);	
		
		RequestDispatcher view = request
				.getRequestDispatcher("/Home.jsp");
		try {
			view.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public void exibeAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ArrayList<VooModelView> lista = new VooController().listarTodosAmv();
		
		request.setAttribute("lista", lista);
		
		RequestDispatcher view = request
				.getRequestDispatcher("/Passagem.jsp");
		view.forward(request, response);
	}

	public void buscarPassagem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("numero"));
		PassagemModel passagem = new PassagemController().buscarId(id);
		if(passagem == null){
			request.setAttribute("msg",
					"<div class='btn btn-danger'>Passagem não encontrada!</div>");
			
			RequestDispatcher view = request
					.getRequestDispatcher("/PassagemBuscar.jsp");
			view.forward(request, response);
		}else{
			exibeCheckin(passagem, request, response);
		}	
	}
	
	public void exibeCheckin(PassagemModel passagem, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setAttribute("passagem", passagem);
		
		RequestDispatcher view = request
				.getRequestDispatcher("/Checkin.jsp");
		view.forward(request, response);
	}
	
	public void checkin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PassagemModel passagem = new PassagemModel();
		passagem.setIdPasagem(Integer.parseInt(request.getParameter("id")));
		passagem.setIdVoo(Integer.parseInt(request.getParameter("idVoo")));
		passagem.setEmail(request.getParameter("email"));
		passagem.setCelular(request.getParameter("celular"));
		passagem.setStatus("Checked");
		passagem.setFileira(Integer.parseInt(request.getParameter("fileira")));
		passagem.setColuna(Integer.parseInt(request.getParameter("coluna")));
		
		new PassagemController().editarPassagem(passagem);
		
		RequestDispatcher view = request
				.getRequestDispatcher("/Home.jsp");
		view.forward(request, response);		
	}
}
