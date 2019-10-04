package br.edu.puc.sca.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.puc.sca.retorno.Resultado;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ComplianceController {

    @RequestMapping("/compliance")
    Resultado compliance(){
        Resultado resultado = new Resultado(0, "Sucesso");

       return resultado;
    }
    

}
