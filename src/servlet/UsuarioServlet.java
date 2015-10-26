package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import model.UsuarioModel;
import controller.UsuarioController;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = { "/UsuarioServlet/create",
		"/UsuarioServlet/edit", "/UsuarioServlet/login" })
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = request.getParameter("url");
		if (url.equals("login")) {
			logar(request, response);
		}
	}

	private void logar(HttpServletRequest request, HttpServletResponse response) {
		try {
			String usuario = request.getParameter("usuario");
			String senha = request.getParameter("senha");

			UsuarioController control = new UsuarioController();
			UsuarioModel usuarioTemp = control.Logar(usuario, senha);

			if (usuarioTemp == null) {
				request.setAttribute("msg",
						"<div class='btn btn-warning'>Usuario invalido!</div>");

				RequestDispatcher view = request
						.getRequestDispatcher("/Login.jsp");
				view.forward(request, response);
			} else {
				
				HttpSession session = request.getSession();
				session.setAttribute("usuario", usuarioTemp);
				session.setMaxInactiveInterval(30 * 60);
				
				RequestDispatcher view = request
						.getRequestDispatcher("/Home.jsp");
				view.forward(request, response);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
