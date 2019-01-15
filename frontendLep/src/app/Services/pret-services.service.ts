import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { map } from 'rxjs/operators';
import { Pret } from '../model/pret';

@Injectable({
  providedIn: 'root'
})
export class PretServicesService {

  constructor(private http:Http) { }

  getPrets(page:number,size:number){
    return this.http.get("http://localhost:8080/listPrets?size="+size+"&page="+page)
    .pipe(map(rest=>rest.json()))
  }

  getCherchePret(motCle:number,page:number,size:number){
    return this.http.get("http://localhost:8080/chercherPret?mc="+motCle+"&size="+size+"&page="+page)
    .pipe(map(rest=>rest.json()))
  }

  getOnePret(id:number){
    return this.http.get("http://localhost:8080/Pret/"+id)
    .pipe(map(rest=>rest.json()))
  }

  savePret(pret:Pret){
    return  this.http.post("http://localhost:8080/savePret",pret)
      .pipe(map(rest=>rest.json()))
  }

  deletePret(id:number){
    return this.http.delete("http://localhost:8080/Pret/"+id)
    .pipe(map(rest=>rest.json()))
  }

  updatePret(pret:Pret){
    return this.http.put("http://localhost:8080/updatePret/"+pret.idpret,pret)
    .pipe(map(rest=>rest.json()))
  }
}
