package controller;

import java.util.ArrayList;

import model.PassagemModel;
import model.VooModelView;
import model.VooModelViewTo;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonFacade {
 //   static VooEspecialista vooesp =new VooEspecialista();	
    
	/*public  static String listOrigem(){
		JSONArray arrayorigem = new JSONArray();
	    ArrayList<String> origem = vooesp.getOrigem();
	    for(int i = 0 ; i < origem.size();i++){
	    JSONObject objetodestino = new JSONObject();
	    try{
	    objetodestino.put("origem",origem.get(i));
	    arrayorigem.put(objetodestino);
	    }
	    catch(Exception ex){
	    	ex.printStackTrace();
	    }
	}
		return arrayorigem.toString();
	}
	
	public String listDestino(){

		JSONArray arraydestino = new JSONArray();
	    ArrayList<String> destinos = vooesp.getDestino();
	    for(int i = 0 ; i < destinos.size();i++){
	    JSONObject objetodestino = new JSONObject();
	    try{
	    objetodestino.put("destino",destinos.get(i));
	    arraydestino.put(objetodestino);
	    }
	    catch(Exception ex){
	    	ex.printStackTrace();
	    }
	}
		return arraydestino.toString();
	}
	public String listVoos(String origem , String destino){

		JSONArray arrayvoo = new JSONArray();
	    ArrayList<Voo> voos = vooesp.getVoos(origem,destino);
	    
	    for(int i = 0 ; i < voos.size();i++){
	    JSONObject objetoVoo = new JSONObject();
	    try{
	    objetoVoo.put("id",voos.get(i).getId());
	    objetoVoo.put("aeronave",voos.get(i).getAeronave());
	    objetoVoo.put("cdvoo",voos.get(i).getCdvoo());
	    objetoVoo.put("escalas",voos.get(i).getEscalas());
	    objetoVoo.put("origem",voos.get(i).getOrigem());
	    objetoVoo.put("destino",voos.get(i).getDestino());
	    objetoVoo.put("data",voos.get(i).getData());
	    objetoVoo.put("situacao",voos.get(i).getSituacao());
	    
	    arrayvoo.put(objetoVoo);
	    }
	    catch(Exception ex){
	    	ex.printStackTrace();
	    }
	}
		return arrayvoo.toString();
	}*/
	
	public String listar(){
		JSONArray arrayvoo = new JSONArray();
		PassagemModel pass = new PassagemController().buscarId(1);
		
		JSONObject obj = new JSONObject();
		try{
		    obj.put("id", pass.getIdPasagem());
		    obj.put("celular", pass.getCelular());
		    
		    arrayvoo.put(obj);
		    }
		    catch(Exception ex){
		    	ex.printStackTrace();
		    }
		return arrayvoo.toString();
	}
	
	public String listarVoos(){
		JSONArray listaVoo = new JSONArray();
		ArrayList<VooModelView> listVmv = new VooController().listarTodosAmv();
		
		for (VooModelView vmv : listVmv) {
			
			try{
				JSONObject obj = new JSONObject();
			    obj.put("idVoo", vmv.getVoo().getIdVoo());
			    obj.put("origem", vmv.getOrigem().getNome());
			    obj.put("destino", vmv.getDestino().getNome());
			    obj.put("aeronave", vmv.getAmv().getAero().getNome());
			    obj.put("data", vmv.getVoo().getData());
			    obj.put("status", vmv.getVoo().getStatus());
			    obj.put("preco", vmv.getVoo().getPreco());
			    
			    listaVoo.put(obj);
		    }
		    catch(Exception ex){
		    	ex.printStackTrace();
		    }
		}
		
		return listaVoo.toString();
	}
	
}
