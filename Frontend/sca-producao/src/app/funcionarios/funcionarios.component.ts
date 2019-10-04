import { Component, OnInit } from '@angular/core';
import {ProducaoService} from '../producao/producao.service'
import {ActivatedRoute} from '@angular/router'
import {Funcionario} from './funcionario/funcionario.model'

@Component({
  selector: 'sca-funcionarios',
  templateUrl: './funcionarios.component.html',
  styleUrls: ['./funcionarios.component.css']
})
export class FuncionariosComponent implements OnInit {

  funcionarios: Funcionario[];

  constructor(private producaoService: ProducaoService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.funcionariosNaProducao();
  }

  funcionariosNaProducao(): void {
      this.producaoService.funcionariosNaProducao(this.route.snapshot.params['id']).subscribe(
        (funcionarios: Funcionario[]) => {
          this.funcionarios = funcionarios;
       }
    )
  }

}
