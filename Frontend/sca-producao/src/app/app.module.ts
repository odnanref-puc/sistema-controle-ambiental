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
import { MinasComponent } from './minas/minas.component';
import {MinasService} from './minas/minas.service'

import {ROUTES} from './app.routes';
import { HomeComponent } from './home/home.component';
import { MinaComponent } from './minas/mina/mina.component';
import { MinaDetalheComponent } from './minas/mina-detalhe/mina-detalhe.component';
import { InputComponent } from './shared/input/input.component';
import { RadioComponent } from './shared/radio/radio.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ComboComponent } from './shared/combo/combo.component';
import { AwesomeTooltipComponent } from './shared/tooltip/tooltip.component';
import { AwesomeTooltipDirective } from './shared/tooltip/tooltip.directive';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { OverlayModule } from '@angular/cdk/overlay';
import { ProducaoComponent } from './producao/producao.component';
import { ProcessoComponent } from './producao/processo/processo.component';
import { ProducaoService } from './producao/producao.service';
import { AtivosComponent } from './ativos/ativos.component';
import { AtivoComponent } from './ativos/ativo/ativo.component';
import { FuncionariosComponent } from './funcionarios/funcionarios.component';
import { FuncionarioComponent } from './funcionarios/funcionario/funcionario.component';
import { DetalheProducaoComponent } from './producao/detalhe-producao/detalhe-producao.component';
import { ProcessoMinaComponent } from './minas/mina-processo/mina-processo.component';
import { BackForwardComponent } from './shared/back-forward/back-forward.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    MinasComponent,
    HomeComponent,
    MinaComponent,
    MinaDetalheComponent,
    InputComponent,
    RadioComponent,
    ComboComponent,
    AwesomeTooltipDirective,
    AwesomeTooltipComponent,
    ProducaoComponent,
    ProcessoComponent,
    AtivosComponent,
    AtivoComponent,
    FuncionariosComponent,
    FuncionarioComponent,
    DetalheProducaoComponent,
    ProcessoMinaComponent,
    BackForwardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxPaginationModule,
    NgbModule,
    OverlayModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(ROUTES)
  ],
  providers: [MinasService, ProducaoService, DatePipe],
  bootstrap: [AppComponent],
  entryComponents: [AwesomeTooltipComponent]
})
export class AppModule { }
