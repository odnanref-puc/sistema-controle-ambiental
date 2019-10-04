import {Injectable} from '@angular/core'
import {HttpClient, HttpHeaders} from '@angular/common/http'

import {Observable} from 'rxjs'
import {Producao} from './detalhe-producao/producao.model'
import {URL_SERVIDOR_PRODUCAO} from '../app.servidor'
import {map, catchError} from 'rxjs/operators'
import {ErrorHandler} from '../app.error-handler'

@Injectable()
export class ProducaoService{

   httpOptions: Object = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
   };

  constructor(private http: HttpClient){}

// PRODUCAO
  producaoAll(): Observable<Producao[]> {
     return this.http.get<Producao[]>(`${URL_SERVIDOR_PRODUCAO}/producao_diaria`)
            .pipe(
              map(resultado => resultado["conteudo"]),
              catchError(ErrorHandler.handleError)
            )
  }


  producaoById(id: number): Observable<Producao>{
    return this.http.get<Producao[]>(`${URL_SERVIDOR_PRODUCAO}/producao_diaria/${id}`)
           .pipe(
             map(resultado => resultado["conteudo"]),
             catchError(ErrorHandler.handleError)
           )
  }

  producoesByMina(id: number): Observable<Producao[]>{
    return this.http.get<Producao[]>(`${URL_SERVIDOR_PRODUCAO}/producao_mina/${id}`)
           .pipe(
             map(resultado => resultado["conteudo"]),
             catchError(ErrorHandler.handleError)
           )
  }

  producaoByMinaAndDate(id: number, data: number): Observable<Producao[]>{
    return this.http.get<Producao[]>(`${URL_SERVIDOR_PRODUCAO}/producao_mina/${id}/${data}`)
           .pipe(
             map(resultado => resultado["conteudo"]),
             catchError(ErrorHandler.handleError)
           )
  }

  producaoByMinaAndPediodo(id: number, data_inicial: number, data_final: number): Observable<Producao[]>{
    return this.http.get<Producao[]>(`${URL_SERVIDOR_PRODUCAO}/producao_mina/${id}/${data_inicial}/${data_final}`)
           .pipe(
             map(resultado => resultado["conteudo"]),
             catchError(ErrorHandler.handleError)
           )
  }



// ATIVO NA PRODUCAO DIARIA
   ativosNaProducao(idProducao: number): Observable<any>{
    return this.http.get<any>(`${URL_SERVIDOR_PRODUCAO}/ativo_na_producao_diaria/${idProducao}`)
           .pipe(
             map(resultado => resultado["conteudo"]),
             catchError(ErrorHandler.handleError)
           )
  }


     funcionariosNaProducao(idProducao: number): Observable<any>{
      return this.http.get<any>(`${URL_SERVIDOR_PRODUCAO}/funcionario_na_producao_diaria/${idProducao}`)
             .pipe(
               map(resultado => resultado["conteudo"]),
               catchError(ErrorHandler.handleError)
             )
    }


}
