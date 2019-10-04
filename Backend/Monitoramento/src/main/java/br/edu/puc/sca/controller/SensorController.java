package br.edu.puc.sca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.puc.sca.model.Sensor;
import br.edu.puc.sca.repository.SensorCustomRepository;
import br.edu.puc.sca.repository.SensorRepository;
import br.edu.puc.sca.retorno.Resultado;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SensorController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    SensorRepository repository;
    @Autowired
    SensorCustomRepository customRepository;

    @RequestMapping("/sensor/{id}")
    Resultado sensorById(@PathVariable("id") int id){
    	Sensor sensor = repository.findOne(Long.valueOf(id));
        if(sensor == null)
            return new Resultado(1000, "Sensor não encontrado");

        Resultado resultado = new Resultado(0, "Sucesso");
        resultado.setConteudo(sensor);

        return resultado;
    }

    @RequestMapping("/sensor")
    Resultado sensorAll(){
        Resultado resultado = new Resultado(0, "Sucesso");
        resultado.setConteudo(repository.findAll());

       return resultado;
    }
    
    @RequestMapping("/sensor_lastest")
    Resultado sensorLatestAll(){
        Resultado resultado = new Resultado(0, "Sucesso");
        resultado.setConteudo(customRepository.findLastestAll());

       return resultado;
    }
}
