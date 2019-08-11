import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ExampleComponent} from './example.component';
import {ExampleHttpService} from "../service/http/example-http.service";
import {of} from "rxjs";
import {ExampleModel} from "./example.model";
import {FormsModule} from "@angular/forms";
import {RouterTestingModule} from "@angular/router/testing";

describe('ExampleComponent', () => {
  let component: ExampleComponent;
  let fixture: ComponentFixture<ExampleComponent>;

  //See Example Details spec
  let serviceStub: any;

  beforeEach(async(() => {
    let examples: ExampleModel [] = [
      new ExampleModel("name 1", 1),
      new ExampleModel("name 2", 2)
    ];

    //See ExampleDetails spec
    serviceStub = {
      getExamples: () => of(examples)
    };

    TestBed.configureTestingModule({
      declarations: [ ExampleComponent ],

      //Imports are required on component level
      //Forms module is not injected automatically and Karma does not know how to handle Routing without Testing Module
      imports: [FormsModule, RouterTestingModule],

      //See ExampleDetails spec
      providers: [{provide: ExampleHttpService, useValue: serviceStub}]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExampleComponent);
    component = fixture.componentInstance;
    component.ngOnInit();
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
