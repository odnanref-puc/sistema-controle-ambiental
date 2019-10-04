import { Component, OnInit } from '@angular/core';
import {ProducaoService} from '../producao/producao.service'
import {ActivatedRoute} from '@angular/router'
import {Ativo} from './ativo/ativo.model'

@Component({
  selector: 'sca-ativos',
  templateUrl: './ativos.component.html',
  styleUrls: ['./ativos.component.css']
})
export class AtivosComponent implements OnInit {

    ativos: Ativo[];

  constructor(private producaoService: ProducaoService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.ativosNaProducao();

  }

  ativosNaProducao(): void{
    this.producaoService.ativosNaProducao(this.route.snapshot.params['id']).subscribe(
      (ativos: Ativo[]) => {
          this.ativos = ativos;
      }
    )
  }

}
