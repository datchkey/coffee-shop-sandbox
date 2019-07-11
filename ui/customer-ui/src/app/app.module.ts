import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ExampleComponent } from './example/example.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { ExampleDetailsComponent } from './example/example-details/example-details.component';
import { NumberMinDirective } from './directives/number-min.directive';
import { NumberMaxDirective } from './directives/number-max.directive';

@NgModule({
  declarations: [
    AppComponent,
    ExampleComponent,
    ExampleDetailsComponent,
    NumberMinDirective,
    NumberMaxDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
