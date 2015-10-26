package controller;

import java.util.ArrayList;

import dao.AeronaveDao;
import dao.VooDao;
import model.AeronaveModel;
import model.VooModel;
import model.VooModelView;

public class VooController {
	
	public ArrayList<VooModelView> listarTodosAmv(){
		return new VooDao().buscarTodosVmv().getLista();
	}
	
	/*public ArrayList<VooModelView> listarTipoTodos(){
		return new VooDao().buscarTodosTipo().getLista();
	}*/
	
	public boolean cadastrarVoo(VooModel voo){
		return new VooDao().cadastrarVoo(voo);
	}
	
	public VooModelView buscarVmvId(int id){
		return new VooDao().buscarVmvId(id);
	}
	
	public boolean editarVoo(VooModel voo){
		return new VooDao().editarVoo(voo);
	}
	
	public boolean removerVoo(int id){
		return new VooDao().excluirVoo(id);
	}
}
