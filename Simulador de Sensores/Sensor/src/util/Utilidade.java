package util;

import com.google.gson.Gson;
import java.util.Random;
import sensor.Sensor;


public class Utilidade {
    
    public static Double sorteiaNumero() {
        Random r = new Random();
        Double num = r.nextDouble()*100;   
        return num;
    }
    
    public static String objectToJson(Sensor sensor) throws Exception{ 
        Gson gson = new Gson();
        String json = gson.toJson(sensor);   
        return json;    
    }   
}
