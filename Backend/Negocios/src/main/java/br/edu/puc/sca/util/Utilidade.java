package br.edu.puc.sca.util;

import com.google.gson.Gson;
import br.edu.puc.sca.bean.Email;

public class Utilidade {
 
    public static String objectToJson(Email email) throws Exception{ 
        Gson gson = new Gson();
        String json = gson.toJson(email);   
        return json;    
    }   
    
    public static Email JsonToObject(String json) throws Exception{ 
        Gson gson = new Gson();
        Email email = gson.fromJson(json, Email.class);   
        return email;    
    }   
}
