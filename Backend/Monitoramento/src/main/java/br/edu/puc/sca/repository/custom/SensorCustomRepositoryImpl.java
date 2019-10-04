package br.edu.puc.sca.repository.custom;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.puc.sca.bean.SensorLastest;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class SensorCustomRepositoryImpl implements CustomRepository<SensorLastest> {
    @PersistenceContext
    EntityManager entityManager;
    
    @SuppressWarnings("unchecked")
	@Override
    public List<SensorLastest> findLastestAll() {
        Query query = entityManager.createNativeQuery(
        		"SELECT sensor.id, sensor.situacao, sensor.unidade_exploracao_id, dados_sensor.temperatura, dados_sensor.pressao \r\n" + 
        		"FROM Sensor sensor JOIN Dados_Sensor dados_sensor ON sensor.id = dados_sensor.sensor_id \r\n" + 
        		"WHERE dados_sensor.data_hora = (SELECT MAX(max.data_hora) as max_data_hora from Dados_Sensor max WHERE dados_sensor.sensor_id = max.sensor_id)"
        		, SensorLastest.class);
        
        return query.getResultList();
    }

}


