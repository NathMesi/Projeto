package model;

import java.io.Serializable;
import java.util.ArrayList;

public class TipoAeronaveTo implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<TipoAeronaveModel> lista;

	public TipoAeronaveTo() {
		lista = new ArrayList<TipoAeronaveModel>();
	}

	public void add(TipoAeronaveModel tipo) {
		lista.add(tipo);
	}

	public boolean remove(TipoAeronaveModel tipo) {
		return (lista.remove(tipo));
	}

	public ArrayList<TipoAeronaveModel> getLista() {
		return lista;
	}
}
