import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { map } from 'rxjs/operators';
import { Client } from '../model/client';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http:Http) { }

  getClients(){
    return this.http.get("http://localhost:8080/listClients")
    .pipe(map(rest=>rest.json())) ;
  }

  saveClient(client:Client){
    return this.http.post("http://localhost:8080/saveClient",client)
    .pipe(map(rest=>rest.json())) ;
  }
}


