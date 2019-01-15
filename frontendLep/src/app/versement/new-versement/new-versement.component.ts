import { Component, OnInit } from '@angular/core';
import { Versement } from '../../model/versement';
import { VersementServicesService } from '../../Services/versement-services.service';

@Component({
  selector: 'app-new-versement',
  templateUrl: './new-versement.component.html',
  styleUrls: ['./new-versement.component.css']
})
export class NewVersementComponent implements OnInit {

  versement:Versement = new Versement();
  mode:number = 1 ;

  constructor(private versementService:VersementServicesService) { }

  ngOnInit() {
  }

  saveVersement(){
    this.versementService.saveVersement(this.versement)
    .subscribe(data=>{
      //console.log(data);
      this.versement = data ;
      this.mode=2;
      
    })
  }

}
