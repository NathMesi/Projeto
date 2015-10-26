package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.JsonFacade;
/**
 * Servlet implementation class VoosJson
 */
@WebServlet(name = "VoosJson", urlPatterns = {"/VoosJson"})
public class VoosJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoosJson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	private void verificaRota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String url = request.getParameter("url");
		
		if(url == null)
			exibir(request, response);
			
		if (url.equals("list"));
			exibir(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		verificaRota(request, response);
		


	}
	
	private void exibir(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
         JsonFacade jf = new JsonFacade();
         PrintWriter out = response.getWriter();
         
		out.println(jf.listarVoos());
	}

}
