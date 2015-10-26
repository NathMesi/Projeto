package model;

import java.io.Serializable;
import java.util.ArrayList;

public class AeroportoTo implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<AeroportoModel> lista;

	public AeroportoTo() {
		lista = new ArrayList<AeroportoModel>();
	}

	public void add(AeroportoModel aero) {
		lista.add(aero);
	}

	public boolean remove(AeroportoModel aero) {
		return (lista.remove(aero));
	}

	public ArrayList<AeroportoModel> getLista() {
		return lista;
	}

}
