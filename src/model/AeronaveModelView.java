package model;


public class AeronaveModelView {
	
	private AeronaveModel aero;
	private TipoAeronaveModel tipo;
	
	public TipoAeronaveModel getTipo() {
		return tipo;
	}
	public void setTipo(TipoAeronaveModel tipo) {
		this.tipo = tipo;
	}
	public AeronaveModel getAero() {
		return aero;
	}
	public void setAero(AeronaveModel aero) {
		this.aero = aero;
	}
}
