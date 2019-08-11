import {async, ComponentFixture, TestBed} from '@angular/core/testing';
import {RouterTestingModule} from '@angular/router/testing';
import {AppComponent} from './app.component';
import {Title} from "@angular/platform-browser";
import {DebugElement} from "@angular/core";

describe('AppComponent', () => {
  let fixture: ComponentFixture<AppComponent>;
  let component: AppComponent;
  let debugElement: DebugElement;

  //before each #1 - 'async'
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule
      ],
      //Title is an existing service provided by Angular, no need to stub
      providers: [{provide: Title, useClass: Title}],
      declarations: [
        AppComponent
      ],
    }).compileComponents();

  }));

  //before each #2 - 'regular'
  beforeEach(() => {
    fixture = TestBed.createComponent(AppComponent);
    debugElement = fixture.debugElement;
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create the app', () => {
    expect(component).toBeTruthy();
  });

  it(`should have as title 'Coffee-Shop Example Sandbox'`, () => {
    expect(component.title).toEqual('Coffee-Shop Example Sandbox');
    expect(component.titleService.getTitle()).toEqual('Coffee-Shop Example Sandbox');
  });

  it('should render title in a h1 tag', () => {
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h1').textContent).toContain('App component');
  });
});
