import { Component, OnInit, Input } from '@angular/core';
import {Mina} from './mina/mina.model'
import {MinasService} from './minas.service'

@Component({
  selector: 'sca-minas',
  templateUrl: './minas.component.html',
  styleUrls: ['./minas.component.css']
})
export class MinasComponent implements OnInit {

  @Input() minas: Mina[];
  page: number;
  totalRec: number;

  constructor(private minasService: MinasService) { }

  ngOnInit() {
    this.buscarMinas()
  }

  buscarMinas(){
    this.minasService.minas().subscribe(minas => this.minas = minas)
  }

  excluirMina(mina: Mina){
    this.minasService.excluirMina(mina).subscribe(
      (resultado: any) => {
        if(resultado.codigo === 0){
          const index = this.minas.findIndex(obj => obj['id'] === mina.id);
          this.minas.splice(index, 1);
        }
    })
  }

}
