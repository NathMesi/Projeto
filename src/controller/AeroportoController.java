package controller;

import java.util.ArrayList;

import dao.AeroportoDao;
import model.AeroportoModel;

public class AeroportoController {

	public ArrayList<AeroportoModel> listarTodos(){
		return new AeroportoDao().buscarTodos().getLista();
	}
	
}
