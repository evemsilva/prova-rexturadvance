import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { TransferenciaCadastroComponent } from './transferencia-cadastro/transferencia-cadastro.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    TransferenciaCadastroComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
