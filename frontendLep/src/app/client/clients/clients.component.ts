import { Component, OnInit } from '@angular/core';
import { ClientService } from '../../Services/client.service';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  clients:any ;

  constructor(private clientServices: ClientService) { }

  ngOnInit() {
     this.clientServices.getClients()
     .subscribe(data=>{
       console.log(data);
       console.log("eeeeeeeeeeeee");
       
       this.clients = data ;
     })
  }

}
