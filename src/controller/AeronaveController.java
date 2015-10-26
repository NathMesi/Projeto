package controller;
import java.util.ArrayList;

import dao.AeronaveDao;
import model.AeronaveModel;
import model.AeronaveModelView;
import model.TipoAeronaveModel;

public class AeronaveController {

	public ArrayList<AeronaveModelView> listarTodosAmv(){
		return new AeronaveDao().buscarTodosAmv().getLista();
	}
	
	public ArrayList<TipoAeronaveModel> listarTipoTodos(){
		return new AeronaveDao().buscarTodosTipo().getLista();
	}
	
	public boolean cadastrarAeronave(AeronaveModel aero){
		return new AeronaveDao().cadastrarAeronave(aero);
	}
	
	public AeronaveModelView buscarAmvId(int id){
		return new AeronaveDao().buscarAmvId(id);
	}
	
	public boolean editarAeronve(AeronaveModel aero){
		return new AeronaveDao().editarAeronave(aero);
	}
	
	public boolean removerAeronave(int id){
		return new AeronaveDao().excluirAeronave(id);
	}
}
