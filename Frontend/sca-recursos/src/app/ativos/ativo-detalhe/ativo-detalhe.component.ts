import { Component, OnInit, Injectable } from '@angular/core';
import {ActivatedRoute} from '@angular/router'
import {Ativo} from '../ativo/ativo.model'
import {AtivosService} from '../ativos.service'
import {FormGroup, FormBuilder, Validators} from '@angular/forms'
import {RadioOption} from '../../shared/radio/radio-option.model'
import {ComboOption} from '../../shared/combo/combo-option.model'
import {NgbDatepickerI18n, NgbDateStruct, NgbCalendar} from '@ng-bootstrap/ng-bootstrap';
import { DatePipe } from '@angular/common';

const I18N_VALUES = {
  'fr': {
    weekdays: ['Lu', 'Ma', 'Me', 'Je', 'Ve', 'Sa', 'Di'],
    months: ['Jan', 'Fév', 'Mar', 'Avr', 'Mai', 'Juin', 'Juil', 'Aou', 'Sep', 'Oct', 'Nov', 'Déc'],
  },
  'pt': {
    weekdays: ['S', 'T', 'Q', 'Q', 'S', 'S', 'D'],
    months: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dec'],
  }
};

@Injectable()
export class I18n {
  language = 'pt';
}


@Injectable()
export class CustomDatepickerI18n extends NgbDatepickerI18n {

  constructor(private _i18n: I18n) {
    super();
  }

  getWeekdayShortName(weekday: number): string {
    return I18N_VALUES[this._i18n.language].weekdays[weekday - 1];
  }
  getMonthShortName(month: number): string {
    return I18N_VALUES[this._i18n.language].months[month - 1];
  }
  getMonthFullName(month: number): string {
    return this.getMonthShortName(month);
  }
  getDayAriaLabel(date: NgbDateStruct): string {
    return `${date.year}-${date.month}-${date.day}`;
  }
}


@Component({
  selector: 'sca-ativo-detalhe',
  templateUrl: './ativo-detalhe.component.html',
  styleUrls: ['./ativo-detalhe.component.css'],
  providers: [I18n, {provide: NgbDatepickerI18n, useClass: CustomDatepickerI18n}]
})


export class AtivoDetalheComponent implements OnInit {

  ativo: Ativo;
  ativoForm: FormGroup;
  mensagem: string;
  titulo: string;
  cadastro: boolean;
  dataSelecionada: any;

  model: NgbDateStruct;
  date: {year: number, month: number};


  situacaoOpcoes: RadioOption[] = [
    {label: 'Em operação', value: 'OPERACAO'},
    {label: 'Em manutenção', value: 'MANUTENCAO'}
  ]

tipoOpcoes: ComboOption[] = [
  {label: 'Intangível', value: 'INTANGIVEL'},
  {label: 'Imobilizado', value: 'IMOBILIZADO'}

]

  constructor(private ativosService: AtivosService,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private calendar: NgbCalendar,
              private datePipe: DatePipe) { }


  selectToday(){
    this.model = this.calendar.getToday();
  }


  ngOnInit() {

    let parametro = this.route.snapshot.params['id'];
    this.cadastro = (parametro == 'add');

    if(this.cadastro){
      this.titulo = 'Cadastro de Ativo';
    }else{
      this.ativosService.ativoById(this.route.snapshot.params['id']).subscribe(
        (ativo: Ativo) => {
            this.titulo = 'Edição de Ativo';
            this.ativo = ativo;

            const iniYear =  Number(this.datePipe.transform(ativo.data_aquisicao, 'yyyy'));
            const iniMonth =  Number(this.datePipe.transform(ativo.data_aquisicao, 'MM'));
            const iniDay =  Number(this.datePipe.transform(ativo.data_aquisicao, 'dd'));
            this.ativo.data_aquisicao = {year: iniYear, month: iniMonth, day: iniDay}

            this.ativoForm.patchValue(this.ativo);

            //this.ativoForm.controls.data_aquisicao.setValue(data_aquisicao);

        }
      )
    }

    this.ativoForm = this.formBuilder.group({
      id: this.formBuilder.control(''),
      nome: this.formBuilder.control('', [Validators.required, Validators.minLength(3)]),
      marca: this.formBuilder.control('', [Validators.required, Validators.minLength(3)]),
      modelo: this.formBuilder.control('', [Validators.required, Validators.minLength(3)]),
      fabricante: this.formBuilder.control('', [Validators.required, Validators.minLength(3)]),
      situacao: this.formBuilder.control('', [Validators.required]),
      data_aquisicao: this.formBuilder.control('', [Validators.required]),
      tempo_garantia: this.formBuilder.control('', [Validators.required]),
      vida_util: this.formBuilder.control('', [Validators.required]),
      valor_aquisicao: this.formBuilder.control('', [Validators.required]),
      valor_residual: this.formBuilder.control('', [Validators.required]),
      descricao: this.formBuilder.control(''),
      tipo: this.formBuilder.control('', [Validators.required])
    })


  }

  onSubmit(): void{

    this.ativo = this.ativoForm.value

    let ativo_temp: Ativo = JSON.parse(JSON.stringify(this.ativo))
    ativo_temp.data_aquisicao = this.getMillisegundos(this.ativo.data_aquisicao.year+'-'+this.ativo.data_aquisicao.month+'-'+this.ativo.data_aquisicao.day)

    if(this.cadastro){
      this.ativosService.cadastrarAtivo(ativo_temp).subscribe(
        (resultado: any) => {
            this.mensagem = resultado.descricao
        }
      )
    }else{
      this.ativosService.atualizarAtivo(ativo_temp).subscribe(
        (resultado: any) => {
            this.mensagem = resultado.descricao
        }
      )
    }
  }

  public getMillisegundos(input: string): number{
      return Date.parse(input)
  }
}
