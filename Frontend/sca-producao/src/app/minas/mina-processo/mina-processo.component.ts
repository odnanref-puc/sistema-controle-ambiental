import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'sca-mina-processo',
  templateUrl: './mina-processo.component.html',
  styleUrls: ['./mina-processo.component.css']
})
export class ProcessoMinaComponent implements OnInit {

  prospeccao: string
  avaliacao: string
  infraestrutura: string
  producao: string
  desativacao: string

  @Input() situacao: number

  constructor() { }

  ngOnInit() {
    this.prospeccao = (this.situacao >= 1) ? 'acionado' : 'nao_acionado'
    this.avaliacao = (this.situacao >= 2) ? 'acionado' : 'nao_acionado'
    this.infraestrutura = (this.situacao >= 3) ? 'acionado' : 'nao_acionado'
    this.producao = (this.situacao >= 4) ? 'acionado' : 'nao_acionado'
    this.desativacao = (this.situacao >= 5) ? 'acionado' : 'nao_acionado'
  }

}
