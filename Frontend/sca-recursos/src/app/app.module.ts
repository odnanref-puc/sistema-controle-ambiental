import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { DatePipe } from '@angular/common';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgxPaginationModule } from 'ngx-pagination';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AtivosComponent } from './ativos/ativos.component';
import {AtivosService} from './ativos/ativos.service'

import {ROUTES} from './app.routes';
import { HomeComponent } from './home/home.component';
import { AtivoComponent } from './ativos/ativo/ativo.component';
import { AtivoDetalheComponent } from './ativos/ativo-detalhe/ativo-detalhe.component';
import { InputComponent } from './shared/input/input.component';
import { RadioComponent } from './shared/radio/radio.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ComboComponent } from './shared/combo/combo.component';
import { BackForwardComponent } from './shared/back-forward/back-forward.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    AtivosComponent,
    HomeComponent,
    AtivoComponent,
    AtivoDetalheComponent,
    InputComponent,
    RadioComponent,
    ComboComponent,
    BackForwardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxPaginationModule,
    NgbModule,
    RouterModule.forRoot(ROUTES)
  ],
  providers: [AtivosService, DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
