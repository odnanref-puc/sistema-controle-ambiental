import {Injectable} from '@angular/core'
import {HttpClient, HttpHeaders} from '@angular/common/http'
import {Observable} from 'rxjs'
import {Email} from './email.model'
import {URL_SERVIDOR_EMAIL} from '../app.servidor'
import {map, catchError} from 'rxjs/operators'
import {ErrorHandler} from '../app.error-handler'

@Injectable()
export class EmailService{

   httpOptions: Object = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
   };

  constructor(private http: HttpClient){}

  enviarEmail(email: Email): Observable <any>{
    return this.http.post<Email>(`${URL_SERVIDOR_EMAIL}/email`, email, this.httpOptions)
          .pipe(
            map(resultado => resultado["mensagem"]),
            catchError(ErrorHandler.handleError)
          )
  }

}
