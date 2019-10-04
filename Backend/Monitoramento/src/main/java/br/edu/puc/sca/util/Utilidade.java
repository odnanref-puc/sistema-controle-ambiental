package br.edu.puc.sca.util;

import com.google.gson.Gson;
import br.edu.puc.sca.model.DadosSensor;

public class Utilidade {
 
    public static String objectToJson(DadosSensor sensor) throws Exception{ 
        Gson gson = new Gson();
        String json = gson.toJson(sensor);   
        return json;    
    }   
    
    public static DadosSensor JsonToObject(String json) throws Exception{ 
        Gson gson = new Gson();
        DadosSensor dadosSensor = gson.fromJson(json, DadosSensor.class);   
        return dadosSensor;    
    }   
}
