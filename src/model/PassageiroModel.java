package model;

import java.sql.Date;

public class PassageiroModel {

	private int idPassageiro;
	private String tipo;
	private String nome;
	private String sobrenome;
	private String tratamento;
	private Date nascimento;
	
	public int getIdPassageiro() {
		return idPassageiro;
	}
	public void setIdPassageiro(int idPassageiro) {
		this.idPassageiro = idPassageiro;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getTratamento() {
		return tratamento;
	}
	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	
}
