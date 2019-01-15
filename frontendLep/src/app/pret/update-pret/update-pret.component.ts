import { Component, OnInit } from '@angular/core';
import { Pret } from '../../model/pret';
import { PretServicesService } from '../../Services/pret-services.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-pret',
  templateUrl: './update-pret.component.html',
  styleUrls: ['./update-pret.component.css']
})
export class UpdatePretComponent implements OnInit {

  id:number ;
  pret:Pret = new Pret();
  mode:number = 1;

  constructor(private activeRoute:ActivatedRoute,private pretService:PretServicesService,
    private router:Router) { }

  ngOnInit() {
    this.id = this.activeRoute.snapshot.params['id'] ;
    this.pretService.getOnePret(this.id)
    .subscribe(data=>{
      this.pret = data ;
    },err=>{
      console.log(err);
      
    })
  }

  updatePret(){
    this.pretService.updatePret(this.pret)
    .subscribe(data=>{
      alert('Mise à jour effectuer avec succés!!!');
      this.router.navigate(['pret']) ;
    })

  }

}
