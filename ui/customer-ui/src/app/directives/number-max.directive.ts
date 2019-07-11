import {Directive, Input} from '@angular/core';
import {FormControl, NG_VALIDATORS, ValidationErrors, Validator} from "@angular/forms";

@Directive({
  selector: '[numberMax]',
  providers: [{provide: NG_VALIDATORS, useExisting: NumberMaxDirective, multi: true}]
})
export class NumberMaxDirective implements Validator {

  @Input()
  numberMax: number;

  validate(control: FormControl): ValidationErrors | null {
    let value = control.value;
    return (value > this.numberMax) ? {"numberMax": true} : null;
  }

}
