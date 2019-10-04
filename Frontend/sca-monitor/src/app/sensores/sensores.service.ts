import {Injectable} from '@angular/core'
import {HttpClient, HttpHeaders} from '@angular/common/http'

import {Observable} from 'rxjs'
import {Sensor} from './sensor/sensor.model'
import {URL_SERVIDOR} from '../app.servidor'
import {map, catchError} from 'rxjs/operators'
import {ErrorHandler} from '../app.error-handler'

import { interval } from 'rxjs'
import { flatMap,startWith } from 'rxjs/operators'

@Injectable()
export class SensoresService{

   httpOptions: Object = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
   };

  constructor(private http: HttpClient){}

  sensores(): Observable<Sensor[]> {

        return interval(10000).pipe(startWith(0), flatMap( () => {

           return this.http.get<Sensor[]>(`${URL_SERVIDOR}/sensor_lastest`)
                      .pipe(
                        map(resultado => resultado["conteudo"]),
                        catchError(ErrorHandler.handleError)
                      )

        }));
  }

}
