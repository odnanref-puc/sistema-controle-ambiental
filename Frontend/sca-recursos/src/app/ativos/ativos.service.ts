import {Injectable} from '@angular/core'
import {HttpClient, HttpHeaders} from '@angular/common/http'

import {Observable} from 'rxjs'
import {Ativo} from './ativo/ativo.model'
import {URL_SERVIDOR} from '../app.servidor'
import {map, catchError} from 'rxjs/operators'
import {ErrorHandler} from '../app.error-handler'

@Injectable()
export class AtivosService{

   httpOptions: Object = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
   };

  constructor(private http: HttpClient){}

  ativos(): Observable<Ativo[]> {
     return this.http.get<Ativo[]>(`${URL_SERVIDOR}/ativo`)
            .pipe(
              map(resultado => resultado["conteudo"]),
              catchError(ErrorHandler.handleError)
            )
  }


  ativoById(id: number): Observable<Ativo>{
    return this.http.get<Ativo>(`${URL_SERVIDOR}/ativo/${id}`)
           .pipe(
             map(resultado => resultado["conteudo"]),
             catchError(ErrorHandler.handleError)
           )
  }


  atualizarAtivo(ativo: Ativo): Observable <any>{
    return this.http.put<Ativo>(`${URL_SERVIDOR}/ativo/${ativo.id}`, ativo, this.httpOptions)
          .pipe(
            map(resultado => resultado["mensagem"]),
            catchError(ErrorHandler.handleError)
          )
  }


  cadastrarAtivo(ativo: Ativo): Observable <any>{
    return this.http.post<Ativo>(`${URL_SERVIDOR}/ativo`, ativo, this.httpOptions)
          .pipe(
            map(resultado => resultado["mensagem"]),
            catchError(ErrorHandler.handleError)
          )
  }


  excluirAtivo(ativo: Ativo): Observable <any>{
    return this.http.delete<Ativo>(`${URL_SERVIDOR}/ativo/${ativo.id}`, this.httpOptions)
          .pipe(
            map(resultado => resultado["mensagem"]),
            catchError(ErrorHandler.handleError)
          )
  }

}
