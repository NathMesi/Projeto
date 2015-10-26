package controller;

import dao.UsuarioDao;
import model.UsuarioModel;

public class UsuarioController {

	public UsuarioModel Logar(String login, String senha){
		return new UsuarioDao().logar(login, senha);
	}
}
