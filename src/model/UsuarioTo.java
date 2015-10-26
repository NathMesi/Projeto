package model;

import java.io.Serializable;
import java.util.ArrayList;

public class UsuarioTo implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<UsuarioModel> lista;

	public UsuarioTo() {
		lista = new ArrayList<UsuarioModel>();
	}

	public void add(UsuarioModel usuario) {
		lista.add(usuario);
	}

	public boolean remove(UsuarioModel usuario) {
		return (lista.remove(usuario));
	}

	public ArrayList<UsuarioModel> getLista() {
		return lista;
	}

}
