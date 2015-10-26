package model;

import java.io.Serializable;
import java.util.ArrayList;

public class PassagemTo implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<PassagemModel> lista;

	public PassagemTo() {
		lista = new ArrayList<PassagemModel>();
	}

	public void add(PassagemModel passagem) {
		lista.add(passagem);
	}

	public boolean remove(PassagemModel passagem) {
		return (lista.remove(passagem));
	}

	public ArrayList<PassagemModel> getLista() {
		return lista;
	}

}
