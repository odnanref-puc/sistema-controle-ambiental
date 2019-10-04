import { Component, OnInit, Input, forwardRef } from '@angular/core';
import {ComboOption} from './combo-option.model'
import {NG_VALUE_ACCESSOR, ControlValueAccessor} from '@angular/forms'

@Component({
  selector: 'sca-combo',
  templateUrl: './combo.component.html',
  providers:[
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => ComboComponent),
      multi: true
    }
  ]
})
export class ComboComponent implements OnInit, ControlValueAccessor {

 @Input() options: ComboOption[]

 value: any
 onChange: any

  constructor() { }

  ngOnInit() {
  }

  setValue(event: any){
    this.value = event.target.value
    this.onChange(this.value)
  }

  writeValue(obj: any): void{
    this.value = obj
  }

  registerOnChange(fn: any): void{
    this.onChange = fn
  }

  registerOnTouched(fn: any): void{}

}
