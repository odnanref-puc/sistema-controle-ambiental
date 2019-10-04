package br.edu.puc.sca;

import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
@WebAppConfiguration
@IntegrationTest({"server.port:5432",
	"spring.datasource.url=jdbc:postgresql://192.168.99.100:5432/seguranca_comunicacao",
	"spring.datasource.username=admin",
	"spring.datasource.password=admin",
	"spring.datasource.driver-class-name=org.postgresql.Driver"})
public class ComplianceControllerTest {
    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    
    @Test
    public void testRecursosAll() throws Exception {
        when().get("/compliance").then()
           .body("mensagem.codigo", is(0));
    }
    
}