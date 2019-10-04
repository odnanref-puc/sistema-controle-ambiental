import { Component, OnInit, Input } from '@angular/core';
import {Ativo} from './ativo/ativo.model'
import {AtivosService} from './ativos.service'

@Component({
  selector: 'sca-ativos',
  templateUrl: './ativos.component.html',
  styleUrls: ['./ativos.component.css']
})
export class AtivosComponent implements OnInit {

  @Input() ativos: Ativo[];
  page: number;
  totalRec: number;

  constructor(private ativosService: AtivosService) { }

  ngOnInit() {
    this.buscarAtivos()
  }

  buscarAtivos(){
    this.ativosService.ativos().subscribe(ativos => this.ativos = ativos)
  }

  excluirAtivo(ativo: Ativo){
    this.ativosService.excluirAtivo(ativo).subscribe(
      (resultado: any) => {
        if(resultado.codigo === 0){
          const index = this.ativos.findIndex(obj => obj['id'] === ativo.id);
          this.ativos.splice(index, 1);
        }
    })
  }

}
