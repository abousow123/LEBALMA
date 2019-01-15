import { Component, OnInit } from '@angular/core';
import { Versement } from '../../model/versement';
import { ActivatedRoute, Router } from '@angular/router';
import { VersementServicesService } from '../../Services/versement-services.service';

@Component({
  selector: 'app-update-versement',
  templateUrl: './update-versement.component.html',
  styleUrls: ['./update-versement.component.css']
})
export class UpdateVersementComponent implements OnInit {

  id:number ;
  versement:Versement = new Versement() ;
  mode:number = 1;

  constructor(private activeRoute:ActivatedRoute,private router:Router,
    private versementService:VersementServicesService) { }

  ngOnInit() {
    this.id = this.activeRoute.snapshot.params['id'] ;
    this.versementService.getOneVersement(this.id)
    .subscribe(data=>{
      this.versement = data ;
    },err=>{
      console.log(err);
      
    })
  }

  updateVersement(){
    this.versementService.updateVersement(this.versement)
    .subscribe(data=>{
      alert('Mise à jour effectuer avec succés!!!');
      this.router.navigate(['versement']) ;
    })

  }

}
