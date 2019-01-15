import { Component, OnInit } from '@angular/core';
import { ClientService } from '../../Services/client.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Client } from '../../model/client';

@Component({
  selector: 'app-update-client',
  templateUrl: './update-client.component.html',
  styleUrls: ['./update-client.component.css']
})
export class UpdateClientComponent implements OnInit {

  id:number ;
  client:Client = new Client() ;
  mode:number = 1;

  constructor(private activeRoute:ActivatedRoute,private clientService:ClientService,private router:Router) { }

  ngOnInit() {
    this.id = this.activeRoute.snapshot.params['id'] ;
    console.log(this.id);
    this.clientService.getOneClient(this.id)
    .subscribe(data=>{
      this.client = data ;
    },err=>{
      console.log(err);
      
    })
  }

  updateClient(){
    console.log(this.client);
    
    this.clientService.updateClient(this.client)
    .subscribe(data=>{
      alert('Mise à jour effectuer avec succés!!!');
      this.router.navigate['clients'] ;
    })
  }


}
