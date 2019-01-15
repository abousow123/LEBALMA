import { Component, OnInit } from '@angular/core';
import { PretServicesService } from '../../Services/pret-services.service';
import { ClientService } from 'src/app/Services/client.service';
import { Pret } from '../../model/pret';
import { Router } from '@angular/router';

@Component({
  selector: 'app-prets',
  templateUrl: './prets.component.html',
  styleUrls: ['./prets.component.css']
})
export class PretsComponent implements OnInit {
  prets:any ;
  client:any ;
  motCle:number ;
  size:number = 5;
  currentPage: number = 0;
  pages:Array<number>;

  constructor(private pretService:PretServicesService,private clientServices: ClientService,
    private router:Router) { }

  ngOnInit() {
    this.doSeach()
  }

  onEditPret(id:number){
    this.router.navigate(['updatePret',id]) ;
  }

  getClient(id:number){
    return this.clientServices.getOneClient(id)
    .subscribe(data=>{
      console.log(data);
      this.client = data ;
    })
  }

  deletePret(e:Pret){
    let confirm = window.confirm('Etes vous sure?');
    if(confirm==true){
      this.pretService.deletePret(e.idpret)
      .subscribe(data=>{
        this.prets.splice(
          this.prets.indexOf(e),1
        );
      },err=>{
        console.log(err);
        
      })

    }
  }

  doSeach(){
    this.pretService.getPrets(this.currentPage,this.size)
    .subscribe(data=>{
      console.log(data.content);
     // console.log(data1.idpret);
       this.prets = data.content ;
       this.pages = new Array(data.totalPages)
    });
  }

  chercher(){
    this.pretService.getCherchePret(this.motCle,this.currentPage,this.size)
    .subscribe(data=>{
      console.log(data.content);
     // console.log(data1.idpret);
       this.prets = data.content ;
       this.pages = new Array(data.totalPages)
    });

  }

  goToPage(i){
    this.currentPage=i ;
    //this.getClients();
    this.doSeach();
  }

}
