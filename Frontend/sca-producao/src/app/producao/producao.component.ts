import { Component, OnInit, Injectable } from '@angular/core';
import {ActivatedRoute} from '@angular/router'
import {Producao} from './detalhe-producao/producao.model'
import {ProducaoService} from './producao.service'
import {FormGroup, FormBuilder} from '@angular/forms'
import {NgbDatepickerI18n, NgbDateStruct, NgbCalendar} from '@ng-bootstrap/ng-bootstrap';


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
  selector: 'sca-producao',
  templateUrl: './producao.component.html',
  styleUrls: ['./producao.component.css'],
  providers: [I18n, {provide: NgbDatepickerI18n, useClass: CustomDatepickerI18n}]
})

export class ProducaoComponent implements OnInit {

  producoes: Producao[];
  producaoForm: FormGroup;
  titulo: string;
  page: number;
  totalRec: number;



  constructor(private producaoService: ProducaoService,
              private route: ActivatedRoute,
              private calendar: NgbCalendar,
              private formBuilder: FormBuilder) { }


  ngOnInit() {

    this.titulo = 'Produção Diária';

    this.producaoService.producoesByMina(this.route.snapshot.params['id']).subscribe(
      (producoes: Producao[]) => {
          this.producoes = producoes;
      }
    )

    this.producaoForm = this.formBuilder.group({
      data_inicial: this.formBuilder.control(''),
      data_final: this.formBuilder.control('')
    })

  }


  producaoByMinaAndPeriodo(): void {

      let data_inicial: number = (this.producaoForm.get('data_inicial').value != '') ?
                  this.getMillisegundos(this.producaoForm.get('data_inicial').value.year+'-'+this.producaoForm.get('data_inicial').value.month+'-'+this.producaoForm.get('data_inicial').value.day) : 0
      let data_final: number = (this.producaoForm.get('data_final').value != '') ?
                  this.getMillisegundos(this.producaoForm.get('data_final').value.year+'-'+this.producaoForm.get('data_final').value.month+'-'+this.producaoForm.get('data_final').value.day) :
                  this.getMillisegundos(this.calendar.getToday().year+'-'+this.calendar.getToday().month+'-'+this.calendar.getToday().day)

      this.producaoService.producaoByMinaAndPediodo(this.route.snapshot.params['id'], data_inicial, data_final).subscribe(
        (producoes: Producao[]) => {
            this.producoes = producoes;
       }
    )
  }


  public getMillisegundos(input: string): number {
      return Date.parse(input)
  }

}
