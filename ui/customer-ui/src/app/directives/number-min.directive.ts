import {Directive, Input} from '@angular/core';
import {FormControl, NG_VALIDATORS, ValidationErrors, Validator} from "@angular/forms";

@Directive({
  selector: '[numberMin]',
  providers: [{provide: NG_VALIDATORS, multi: true, useExisting: NumberMinDirective}]
})
export class NumberMinDirective implements Validator{

  @Input()
  numberMin: number;

  validate(control: FormControl): ValidationErrors | null {
    let value = control.value;
    return (value < this.numberMin) ? {"numberMin" : true} : null;
  }


}
