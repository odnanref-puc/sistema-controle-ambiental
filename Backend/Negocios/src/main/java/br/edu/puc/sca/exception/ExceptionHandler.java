
package br.edu.puc.sca.exception;

import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.puc.sca.retorno.Resultado;

@RestController
public class ExceptionHandler implements ErrorController {

    @RequestMapping("/error")
    @ResponseBody
    public Resultado handleError(HttpServletRequest request) {
        Object status = request.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        Integer code = status != null? (Integer)status: 999;
        String mensagem = exception==null? "N/A": exception.getMessage();      

        switch (code) {
            case 400: {
                mensagem = "Erro 400  - Requisição inválida";
                break;
            }
            case 401: {
                mensagem = "Erro 401 - Não autorizado";
                break;
            }
            case 404: {
                mensagem = "Erro 404 - Recurso não encontrado";
                break;
            }
            case 500: {
                mensagem = "Erro 500 - Erro interno no servidor";
                break;
            }          
        }
        return new Resultado(code, mensagem); 
    }


    @Override
    public String getErrorPath() {
        return "/error";
    }
}
