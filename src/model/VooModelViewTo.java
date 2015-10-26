package model;

import java.io.Serializable;
import java.util.ArrayList;

public class VooModelViewTo implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<VooModelView> lista;
	
	public VooModelViewTo() {
		lista = new ArrayList<VooModelView>();
	}

	public void add(VooModelView amv) {
		lista.add(amv);
	}

	public boolean remove(VooModelView amv) {
		return (lista.remove(amv));
	}

	public ArrayList<VooModelView> getLista() {
		return lista;
	}

}
