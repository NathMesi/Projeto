package model;

public class VooModelView {

	private VooModel voo;
	private AeroportoModel origem;
	private AeroportoModel destino;
	private AeronaveModelView amv;
	
	public VooModel getVoo() {
		return voo;
	}
	public void setVoo(VooModel voo) {
		this.voo = voo;
	}
	public AeroportoModel getOrigem() {
		return origem;
	}
	public void setOrigem(AeroportoModel origem) {
		this.origem = origem;
	}
	public AeroportoModel getDestino() {
		return destino;
	}
	public void setDestino(AeroportoModel destino) {
		this.destino = destino;
	}
	public AeronaveModelView getAmv() {
		return amv;
	}
	public void setAmv(AeronaveModelView amv) {
		this.amv = amv;
	}	
}
