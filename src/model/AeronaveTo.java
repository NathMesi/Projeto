package model;

import java.io.Serializable;
import java.util.ArrayList;

public class AeronaveTo implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<AeronaveModel> lista;

	public AeronaveTo() {
		lista = new ArrayList<AeronaveModel>();
	}

	public void add(AeronaveModel aeronave) {
		lista.add(aeronave);
	}

	public boolean remove(AeronaveModel aeronave) {
		return (lista.remove(aeronave));
	}

	public ArrayList<AeronaveModel> getLista() {
		return lista;
	}

}
