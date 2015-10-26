package controller;

import java.util.ArrayList;

import dao.AeronaveDao;
import dao.PassageiroDao;
import dao.PassagemDao;
import dao.VooDao;
import model.AeronaveModel;
import model.PassageiroModel;
import model.PassagemModel;
import model.VooModel;
import model.VooModelView;

public class PassageiroController {
	
	public ArrayList<VooModelView> listarTodosAmv(){
		return new VooDao().buscarTodosVmv().getLista();
	}
	
	/*public ArrayList<VooModelView> listarTipoTodos(){
		return new VooDao().buscarTodosTipo().getLista();
	}*/
	
	public int buscarUltimoId(){
		return new PassageiroDao().buscarUltimoId();
	}
	
	public boolean cadastrarPassageiro(PassageiroModel pass){
		return new PassageiroDao().cadastrarPassageiro(pass);
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
