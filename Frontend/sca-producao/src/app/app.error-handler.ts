import {HttpResponse} from '@angular/common/http'
import {Observable} from 'rxjs'

export class ErrorHandler{

  static handleError(error: Response | any){
    let errorMessage: string;

    if(error instanceof Response){
       errorMessage = `Erro ${error.status} ao acessar a URL ${error.url} - ${error.statusText}`
    }else{
       errorMessage = error;
    }

    console.log(JSON.stringify(errorMessage));
    return Observable.throw(errorMessage);
  }
}
