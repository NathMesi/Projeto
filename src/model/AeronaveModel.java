package model;

public class AeronaveModel {

	private int idAeronave;
	private int idTipo;
	private String nome;
	private int qtdAssentos;
	private int fileira;
	private int coluna;
	
	public int getIdAeronave() {
		return idAeronave;
	}
	public void setIdAeronave(int idAeronave) {
		this.idAeronave = idAeronave;
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public int getQtdAssentos() {
		return qtdAssentos;
	}
	public void setQtdAssentos(int qtdAssentos) {
		this.qtdAssentos = qtdAssentos;
	}
	public int getFileira() {
		return fileira;
	}
	public void setFileira(int fileira) {
		this.fileira = fileira;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getColuna() {
		return coluna;
	}
	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	
}
