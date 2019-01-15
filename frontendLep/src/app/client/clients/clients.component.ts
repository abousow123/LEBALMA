import { Component, OnInit } from '@angular/core';
import { ClientService } from '../../Services/client.service';
import { Router } from '@angular/router';
import { Client } from '../../model/client';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  clients:any ;

  motCle:string="";

  size:number = 5;
  currentPage: number = 0;

  pages:Array<number>;

  constructor(private clientServices: ClientService,private router:Router) { }

  ngOnInit() {
   // this.getClients();

     this.doSeach();
  }

  onEditClient(cni:number){
    console.log(cni);
    
     this.router.navigate(['updateClient',cni]) ;
  }

  deleteClient(e:Client){
    let confirm = window.confirm('Etes vous sure?');
    if(confirm==true){
      this.clientServices.deleteClient(e.cni)
      .subscribe(data=>{
        this.clients.content.splice(
          this.clients.content.indexOf(e),1
        );
      },err=>{
        console.log(err);
        
      })

    }
   

  }

  getClients(){
    this.clientServices.getClients()
     .subscribe(data=>{
       console.log(data);
      // console.log(data['pret']);
       
       this.clients = data ;
       this.pages = new Array(data.totalPages)
       //this.prets = data['pret'] ;
     })
  }


  doSeach(){
    console.log(this.motCle);
    
    this.clientServices.chercherClient(this.motCle,this.currentPage,this.size)
    .subscribe(data=>{
      console.log(data.content.pret);
      
      this.clients = data ;
      this.pages = new Array(data.totalPages)
      //console.log(this.pages);
      
    },err=>{
      console.log(err);
      
    });
    
  }

  chercher(){
    this.doSeach();

  }

  goToPage(i){
    this.currentPage=i ;
    //this.getClients();
    this.doSeach();
  }

}
