import {Injectable} from '@angular/core'
import {HttpClient, HttpHeaders} from '@angular/common/http'

import {Observable} from 'rxjs'
import {Mina} from './mina/mina.model'
import {URL_SERVIDOR} from '../app.servidor'
import {map, catchError} from 'rxjs/operators'
import {ErrorHandler} from '../app.error-handler'

@Injectable()
export class MinasService{

   httpOptions: Object = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
   };

  constructor(private http: HttpClient){}

  minas(): Observable<Mina[]> {
     return this.http.get<Mina[]>(`${URL_SERVIDOR}/mina`)
            .pipe(
              map(resultado => resultado["conteudo"]),
              catchError(ErrorHandler.handleError)
            )
  }


  minaById(id: number): Observable<Mina>{
    return this.http.get<Mina>(`${URL_SERVIDOR}/mina/${id}`)
           .pipe(
             map(resultado => resultado["conteudo"]),
             catchError(ErrorHandler.handleError)
           )
  }


  atualizarMina(mina: Mina): Observable <any>{
    return this.http.put<Mina>(`${URL_SERVIDOR}/mina/${mina.id}`, mina, this.httpOptions)
          .pipe(
            map(resultado => resultado["mensagem"]),
            catchError(ErrorHandler.handleError)
          )
  }


  cadastrarMina(mina: Mina): Observable <any>{
    return this.http.post<Mina>(`${URL_SERVIDOR}/mina`, mina, this.httpOptions)
          .pipe(
            map(resultado => resultado["mensagem"]),
            catchError(ErrorHandler.handleError)
          )
  }


  excluirMina(mina: Mina): Observable <any>{
    return this.http.delete<Mina>(`${URL_SERVIDOR}/mina/${mina.id}`, this.httpOptions)
          .pipe(
            map(resultado => resultado["mensagem"]),
            catchError(ErrorHandler.handleError)
          )
  }

}
