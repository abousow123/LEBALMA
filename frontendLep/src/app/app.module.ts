import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule, Http } from '@angular/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClientsComponent } from './client/clients/clients.component';
import { ClientService } from './Services/client.service';
import { NewClientComponent } from './client/new-client/new-client.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientsComponent,
    NewClientComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpModule
  ],
  providers: [ClientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
