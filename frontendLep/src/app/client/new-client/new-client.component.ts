import { Component, OnInit } from '@angular/core';
import { Client } from '../../model/client';
import { ClientService } from '../../Services/client.service';

@Component({
  selector: 'app-new-client',
  templateUrl: './new-client.component.html',
  styleUrls: ['./new-client.component.css']
})
export class NewClientComponent implements OnInit {

client:Client = new Client() ;
mode:number=1;

  constructor(private clientServices:ClientService) { }

  ngOnInit() {
  }
  
  saveClient(){
    this.clientServices.saveClient(this.client)
    .subscribe(data=>{
      //console.log(data);
      this.client = data ;
      this.mode=2;
      
    })
    
  }

}
