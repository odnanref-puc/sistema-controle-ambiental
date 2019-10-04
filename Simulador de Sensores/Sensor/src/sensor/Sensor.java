package sensor;

public class Sensor {
    
    private String sensor_id;
    private String pressao;
    private String temperatura;

    public Sensor(String sensor_id, String pressao, String temperatura) {
        this.sensor_id = sensor_id;
        this.pressao = pressao;
        this.temperatura = temperatura;
    }

    public String getSensor_id() {
        return sensor_id;
    }

    public void setSensor_id(String sensor_id) {
        this.sensor_id = sensor_id;
    }
    
    public String getPressao() {
        return pressao;
    }

    public void setPressao(String pressao) {
        this.pressao = pressao;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }
}
