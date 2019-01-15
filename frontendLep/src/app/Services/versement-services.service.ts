import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { map } from 'rxjs/operators';
import { Versement } from '../model/versement';

@Injectable({
  providedIn: 'root'
})
export class VersementServicesService {

  constructor(private http:Http) { }

  getVersements(page:number,size:number){
    return this.http.get("http://localhost:8080/listVersements?size="+size+"&page="+page)
    .pipe(map(rest=>rest.json()))
  }

  chercherVersement(motCle:number,page:number,size:number){
    return this.http.get("http://localhost:8080/chercherVersement?mc="+motCle+"&size="+size+"&page="+page)
    .pipe(map(rest=>rest.json()))

  }

  getOneVersement(id:number){
    return this.http.get("http://localhost:8080/Versement/"+id)
    .pipe(map(rest=>rest.json())) ;
  }

  saveVersement(v:Versement){
    return  this.http.post("http://localhost:8080/saveVersement",v)
      .pipe(map(rest=>rest.json()))
  }

  deleteVersement(id:number){
    return this.http.delete("http://localhost:8080/Versement/"+id)
    .pipe(map(rest=>rest.json()))
  }

  updateVersement(v:Versement){
    return this.http.put("http://localhost:8080/updateVersement/"+v.idverser,v)
    .pipe(map(rest=>rest.json()))
  }
}
