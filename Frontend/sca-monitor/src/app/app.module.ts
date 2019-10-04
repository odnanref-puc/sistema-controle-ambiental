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
import { SensoresComponent } from './sensores/sensores.component';
import {SensoresService} from './sensores/sensores.service'
import {EmailService} from './email/email.service'

import {ROUTES} from './app.routes';
import { HomeComponent } from './home/home.component';
import { AtivoComponent } from './sensores/sensor/sensor.component';
import { InputComponent } from './shared/input/input.component';
import { RadioComponent } from './shared/radio/radio.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ComboComponent } from './shared/combo/combo.component';
import { EmailComponent } from './email/email.component';
import { BackForwardComponent } from './shared/back-forward/back-forward.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    SensoresComponent,
    HomeComponent,
    AtivoComponent,
    InputComponent,
    RadioComponent,
    ComboComponent,
    EmailComponent,
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
  providers: [SensoresService, EmailService, DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
