package model;

public class PassagemModel {

	private int idPasagem;
	private int idVoo;
	private String email;
	private String celular;
	private String status;
	private int fileira;
	private int coluna;
	
	public int getIdPasagem() {
		return idPasagem;
	}
	public void setIdPasagem(int idPasagem) {
		this.idPasagem = idPasagem;
	}
	public int getIdVoo() {
		return idVoo;
	}
	public void setIdVoo(int idVoo) {
		this.idVoo = idVoo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getColuna() {
		return coluna;
	}
	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	public int getFileira() {
		return fileira;
	}
	public void setFileira(int fileira) {
		this.fileira = fileira;
	}
}
