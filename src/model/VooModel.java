package model;

import java.sql.Date;
import java.sql.Time;

public class VooModel {

	
	private int idVoo;
	private int idOrigem;
	private int idDestino;
	private int idAeronave;
	private Date data;
	private Time hora;
	private double preco;
	private String status;
	
	public int getIdVoo() {
		return idVoo;
	}
	public void setIdVoo(int idVoo) {
		this.idVoo = idVoo;
	}
	public int getIdOrigem() {
		return idOrigem;
	}
	public void setIdOrigem(int idOrigem) {
		this.idOrigem = idOrigem;
	}
	public int getIdDestino() {
		return idDestino;
	}
	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getIdAeronave() {
		return idAeronave;
	}
	public void setIdAeronave(int idAeronave) {
		this.idAeronave = idAeronave;
	}
	
}
