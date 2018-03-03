import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { TransferenciaCadastroComponent } from './transferencia-cadastro/transferencia-cadastro.component';


import {TableModule} from 'primeng/table';
import {InputMaskModule} from 'primeng/inputmask';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import {CalendarModule} from 'primeng/calendar';
import { CurrencyMaskModule } from "ng2-currency-mask";

import { HttpClientModule } from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations'

import { TransferenciaService } from './transferencia.service';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    TransferenciaCadastroComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    TableModule,
    InputMaskModule,
    CalendarModule,
    HttpClientModule,
    FormsModule,
    AngularFontAwesomeModule,
    CurrencyMaskModule
  ],
  providers: [
    TransferenciaService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
