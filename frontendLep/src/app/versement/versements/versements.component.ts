import { Component, OnInit } from '@angular/core';
import { Versement } from '../../model/versement';
import { VersementServicesService } from '../../Services/versement-services.service';
import { ClientService } from 'src/app/Services/client.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-versements',
  templateUrl: './versements.component.html',
  styleUrls: ['./versements.component.css']
})
export class VersementsComponent implements OnInit {

  versement:any ;
  client:any ;
  motCle:number ;
  size:number = 5;
  currentPage: number = 0;
  pages:Array<number>;
  constructor(private versementService:VersementServicesService,private clientServices: ClientService,
    private router:Router) { }

  ngOnInit() {
    this.doSeach() ;
  }

  doSeach(){
    this.versementService.getVersements(this.currentPage,this.size)
    .subscribe(data=>{
      console.log(data.content);
     // console.log(data1.idpret);
       this.versement = data.content ;
       this.pages = new Array(data.totalPages)
    });
  }

  chercher(){
    this.versementService.chercherVersement(this.motCle,this.currentPage,this.size)
    .subscribe(data=>{
      console.log(data.content);
     // console.log(data1.idpret);
       this.versement = data.content ;
       this.pages = new Array(data.totalPages)
    });

  }

  getClient(id:number){
    return this.clientServices.getOneClient(id)
    .subscribe(data=>{
      console.log(data);
      this.client = data ;
    })
  }

  onEditVersement(id:number){
    this.router.navigate(['updateVersement',id]) ;
  }


  deleteVersement(e:Versement){
    let confirm = window.confirm('Etes vous sure?');
    if(confirm==true){
      this.versementService.deleteVersement(e.idverser)
      .subscribe(data=>{
        this.versement.splice(
          this.versement.indexOf(e),1
        );
      },err=>{
        console.log(err);
        
      })

    }
  }

  goToPage(i){
    this.currentPage=i ;
    //this.getClients();
    this.doSeach();
  }

}
