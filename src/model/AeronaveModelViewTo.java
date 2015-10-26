package model;

import java.io.Serializable;
import java.util.ArrayList;

public class AeronaveModelViewTo implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<AeronaveModelView> lista;
	
	public AeronaveModelViewTo() {
		lista = new ArrayList<AeronaveModelView>();
	}

	public void add(AeronaveModelView amv) {
		lista.add(amv);
	}

	public boolean remove(AeronaveModelView amv) {
		return (lista.remove(amv));
	}

	public ArrayList<AeronaveModelView> getLista() {
		return lista;
	}

}
