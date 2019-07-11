import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ExampleComponent} from "./example/example.component";
import {ExampleDetailsComponent} from "./example/example-details/example-details.component";

const routes: Routes = [
  {path: '', component: ExampleComponent},
  {path: 'examples', component: ExampleComponent},
  {path: 'examples/:id', component: ExampleDetailsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
