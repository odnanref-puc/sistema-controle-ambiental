import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router'
import {Mina} from '../mina/mina.model'
import {MinasService} from '../minas.service'
import {FormGroup, FormBuilder} from '@angular/forms'
import { DatePipe } from '@angular/common';


@Component({
  selector: 'sca-mina-detalhe',
  templateUrl: './mina-detalhe.component.html',
  styleUrls: ['./mina-detalhe.component.css']
})

export class MinaDetalheComponent implements OnInit {

  mina: Mina;
  minaForm: FormGroup;
  titulo: string;

  constructor(private minasService: MinasService,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private datePipe: DatePipe) { }

  ngOnInit() {
    this.titulo = 'Detalhes';
    this.minasService.minaById(this.route.snapshot.params['id']).subscribe(
      (mina: Mina) => {
          this.mina = mina;
          this.mina.inicio_operacao =  this.datePipe.transform(mina.inicio_operacao, 'yyyy-MM-dd');
          this.mina.fim_operacao =  this.datePipe.transform(mina.fim_operacao, 'yyyy-MM-dd');
          this.minaForm.patchValue(this.mina);
      }
    )

    this.minaForm = this.formBuilder.group({
      id: this.formBuilder.control(''),
      nome: this.formBuilder.control(''),
      latitude: this.formBuilder.control(''),
      longitude: this.formBuilder.control(''),
      bairro: this.formBuilder.control(''),
      cidade: this.formBuilder.control(''),
      estado: this.formBuilder.control(''),
      pais: this.formBuilder.control(''),
      inicio_operacao: this.formBuilder.control(''),
      fim_operacao: this.formBuilder.control(''),
      situacao: this.formBuilder.control(''),
      capacidade_prevista: this.formBuilder.control('')
    })
  }

}
