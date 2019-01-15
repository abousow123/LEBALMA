import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule, Http } from '@angular/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClientsComponent } from './client/clients/clients.component';
import { ClientService } from './Services/client.service';
import { NewClientComponent } from './client/new-client/new-client.component';
import { PretsComponent } from './pret/prets/prets.component';
import { UpdateClientComponent } from './client/update-client/update-client.component';
import { Routes, RouterModule } from '@angular/router';
import { NewPretComponent } from './pret/new-pret/new-pret.component';
import { UpdatePretComponent } from './pret/update-pret/update-pret.component';
import { VersementsComponent } from './versement/versements/versements.component';
import { PretServicesService } from './Services/pret-services.service';
import { Versement } from './model/versement';
import { UpdateVersementComponent } from './versement/update-versement/update-versement.component';
import { NewVersementComponent } from './versement/new-versement/new-versement.component';
import { VersementServicesService } from './Services/versement-services.service';


const routes: Routes = [
  { path: 'client', component: ClientsComponent },
  { path: 'pret', component: PretsComponent },
  { path: 'versement', component: VersementsComponent },
  { path: 'updateClient/:id', component: UpdateClientComponent },
  { path: 'updatePret/:id', component: UpdatePretComponent },
  { path: 'updateVersement/:id', component: UpdateVersementComponent },
  { path: 'newClient', component: NewClientComponent },
  { path: 'newPret', component: NewPretComponent },
  { path: 'newVersement', component: NewVersementComponent },
  { path: '', redirectTo: '/client', pathMatch: 'full' }
];

@NgModule({
  declarations: [
    AppComponent,
    ClientsComponent,
    NewClientComponent,
    PretsComponent,
    UpdateClientComponent,
    NewPretComponent,
    UpdatePretComponent,
    VersementsComponent,
    UpdateVersementComponent,
    NewVersementComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpModule
  ],
  providers: [ClientService,PretServicesService,VersementServicesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
