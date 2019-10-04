import { Component, Input, OnInit } from '@angular/core';
import {Producao} from '../detalhe-producao/producao.model';

@Component({
  selector: 'sca-processo',
  templateUrl: './processo.component.html',
  styleUrls: ['./processo.component.css']
})
export class ProcessoComponent implements OnInit {

  @Input() processo_producao: Producao

  ngOnInit() {
  }

}
