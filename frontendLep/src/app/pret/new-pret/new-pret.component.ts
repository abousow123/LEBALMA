import { Component, OnInit } from '@angular/core';
import { Pret } from '../../model/pret';
import { PretServicesService } from '../../Services/pret-services.service';

@Component({
  selector: 'app-new-pret',
  templateUrl: './new-pret.component.html',
  styleUrls: ['./new-pret.component.css']
})
export class NewPretComponent implements OnInit {

  pret: Pret = new Pret();
  mode:number=1;

  constructor(private pretService:PretServicesService) { }

  ngOnInit() {
  }

  savePret(){
    this.pretService.savePret(this.pret)
    .subscribe(data=>{
      //console.log(data);
      this.pret = data ;
      this.mode=2;
      
    })
  }

  

}
