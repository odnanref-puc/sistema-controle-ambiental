import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router'
import {Producao} from './producao.model'
import {ProducaoService} from '../producao.service'


@Component({
  selector: 'sca-detalhe-producao',
  templateUrl: './detalhe-producao.component.html',
  styleUrls: ['./detalhe-producao.component.css']
})

export class DetalheProducaoComponent implements OnInit {

  producao: Producao;
  titulo: string;

  constructor(private producaoService: ProducaoService,
              private route: ActivatedRoute) {}

  ngOnInit() {

    this.titulo = 'Detalhes da Produção';

    this.producaoService.producaoById(this.route.snapshot.params['id']).subscribe(
      (producao: Producao) => {
          this.producao = producao;
      }
    )

  }

}
