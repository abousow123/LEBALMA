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

  getOneClient(id:number){
    return this.http.get("http://localhost:8080/Client/"+id)
    .pipe(map(rest=>rest.json()))
  }

  saveClient(client:Client){
    return this.http.post("http://localhost:8080/saveClient",client)
    .pipe(map(rest=>rest.json())) ;
  }

  chercherClient(motCle:string,page:number,size:number){
    return this.http.get("http://localhost:8080/chercherClient?mc="+motCle+"&size="+size+"&page="+page)
    .pipe(map(rest=>rest.json()))
  }

  deleteClient(id:number){
    return this.http.delete("http://localhost:8080/Client/"+id)
    .pipe(map(rest=>rest.json()))
  }

  updateClient(client:Client){
    return this.http.put("http://localhost:8080/updateClient/"+client.cni,client)
    .pipe(map(rest=>rest.json()))
  }

}


