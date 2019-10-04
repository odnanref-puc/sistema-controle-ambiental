import { Component, OnInit, Input } from '@angular/core';
import {Sensor} from './sensor/sensor.model'
import {SensoresService} from './sensores.service'

@Component({
  selector: 'sca-sensores',
  templateUrl: './sensores.component.html',
  styleUrls: ['./sensores.component.css']
})
export class SensoresComponent implements OnInit {

  @Input() sensores: Sensor[];
  page: number;
  totalRec: number;

  constructor(private sensoresService: SensoresService) { }

  ngOnInit() {
    this.buscarSensores()
  }

  buscarSensores(){
    this.sensoresService.sensores().subscribe(sensores => this.sensores = sensores)
  }

}
