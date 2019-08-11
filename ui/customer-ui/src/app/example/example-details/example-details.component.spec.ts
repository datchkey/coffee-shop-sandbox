import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExampleDetailsComponent } from './example-details.component';
import {of} from "rxjs";
import {ExampleDetailsModel} from "./example-details.model";
import {ExampleHttpService} from "../../service/http/example-http.service";
import {RouterTestingModule} from "@angular/router/testing";

describe('ExampleDetailsComponent', () => {
  let component: ExampleDetailsComponent;
  let fixture: ComponentFixture<ExampleDetailsComponent>;

  //declaring stub globally
  let serviceStub: any;

  let DEFAULT_EXAMPLE_DETAILS: ExampleDetailsModel = new ExampleDetailsModel(
    1,
    "name",
    "email@site.com",
    "https://test.com",
    100
  );

  beforeEach(async(() => {

    //defining service stub: what to return
    serviceStub = {
      getExampleById: () => of(DEFAULT_EXAMPLE_DETAILS)
    };

    TestBed.configureTestingModule({
      declarations: [ ExampleDetailsComponent ],
      //Values like 'provide' and 'useValue' do not have hints with code complete. Enter manually
      //useValue - tells which stub is going to be used
      providers: [{provide: ExampleHttpService, useValue: serviceStub}],
      imports: [RouterTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExampleDetailsComponent);
    component = fixture.componentInstance;
    component.ngOnInit();
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('check data from service', () => {
    component.getExample();

    expect(component.example.name).toEqual(DEFAULT_EXAMPLE_DETAILS.name);
    expect(component.example.email).toEqual(DEFAULT_EXAMPLE_DETAILS.email);
    expect(component.example.price).toEqual(DEFAULT_EXAMPLE_DETAILS.price);
    expect(component.example.imageUrl).toEqual(DEFAULT_EXAMPLE_DETAILS.imageUrl);
    expect(component.example.id).toEqual(DEFAULT_EXAMPLE_DETAILS.id);
  });
});
