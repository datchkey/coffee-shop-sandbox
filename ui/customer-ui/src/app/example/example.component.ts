import { Component, OnInit } from '@angular/core';
import {ExampleHttpService} from "../service/http/example-http.service";
import {ExampleModel} from "./example.model";
import {ExampleDetailsModel} from "./example-details/example-details.model";

@Component({
  selector: 'app-example',
  templateUrl: './example.component.html',
  styleUrls: ['./example.component.css']
})
export class ExampleComponent implements OnInit {

  public tableRowsShadows: boolean [] = [];
  public examples: ExampleModel[] = [];
  public currentExample: ExampleDetailsModel = new ExampleDetailsModel();

  constructor(private exampleHttpService: ExampleHttpService) {
  }

  getExamples() {
    return this.exampleHttpService.getExamples().subscribe(data => this.examples = data);
  }
  saveExample(f) {
    return this.exampleHttpService.saveExample(this.currentExample).subscribe(data => {
      this.examples.push(data);
      this.currentExample = new ExampleDetailsModel();
      f.submitted = false;
    });
  }

  ngOnInit() {
    this.getExamples();
  }

}
