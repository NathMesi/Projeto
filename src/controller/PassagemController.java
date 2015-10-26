package controller;

import java.util.ArrayList;

import dao.AeronaveDao;
import dao.PassagemDao;
import dao.VooDao;
import model.AeronaveModel;
import model.PassagemModel;
import model.Rel_Pass_Passg;
import model.VooModel;
import model.VooModelView;

public class PassagemController {
	
	public ArrayList<VooModelView> listarTodosAmv(){
		return new VooDao().buscarTodosVmv().getLista();
	}
	
	/*public ArrayList<VooModelView> listarTipoTodos(){
		return new VooDao().buscarTodosTipo().getLista();
	}*/
	
	public int buscarUltimoId(){
		return new PassagemDao().buscarUltimoId();
	}
	
	public PassagemModel buscarId(int id){
		return new PassagemDao().buscarId(id);
	}
	
	public boolean cadastrarPassagem(PassagemModel pass){
		return new PassagemDao().cadastrarPassagem(pass);
	}
	
	public boolean editarPassagem(PassagemModel passagem){
		return new PassagemDao().editarPassagem(passagem);
	}
	
	
	/**
	 *  Rel
	 */
	public boolean cadastrarRel(Rel_Pass_Passg rel){
		return new PassagemDao().cadastrarRel(rel);
	}
	
	public void cadastrarRel(ArrayList<Rel_Pass_Passg> list){
		for(Rel_Pass_Passg rel : list)
		{
			cadastrarRel(rel);
		}
	}
	
}
