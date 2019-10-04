package br.edu.puc.sca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DadosSensor{

	@Id
	@GeneratedValue
    private Long id;
    private Double temperatura;
    private Double pressao;
    private Long sensor_id;
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Double getTemperatura() {
		return temperatura;
	}
	
	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}
	
	public Double getPressao() {
		return pressao;
	}
	
	public void setPressao(Double pressao) {
		this.pressao = pressao;
	}
	
	public Long getSensor_id() {
		return sensor_id;
	}
	
	public void setSensor_id(Long sensor_id) {
		this.sensor_id = sensor_id;
	}	

	@Override
	public String toString() {
		return "DadosSensor [id=" + id + ", temperatura=" + temperatura + ", pressao=" + pressao + ", sensor_id="
				+ sensor_id + "]";
	}
}