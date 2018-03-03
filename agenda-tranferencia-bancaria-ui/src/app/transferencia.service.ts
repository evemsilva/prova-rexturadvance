import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class TransferenciaService {

  url = 'http://localhost:9090/v1/transferencias';

  constructor(private http: HttpClient) { }

  listar(){
    return this.http.get<any[]>(this.url);
  }

  adicionar(transacao: any){
    return this.http.post(this.url, transacao);
  }

}
