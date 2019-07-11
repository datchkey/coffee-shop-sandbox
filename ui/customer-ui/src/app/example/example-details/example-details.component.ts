import {Component, OnInit} from '@angular/core';
import {Location} from '@angular/common';
import {ExampleHttpService} from "../../service/http/example-http.service";
import {ActivatedRoute} from "@angular/router";
import {ExampleDetailsModel} from "./example-details.model";

@Component({
  selector: 'app-example-details',
  templateUrl: './example-details.component.html',
  styleUrls: ['./example-details.component.css']
})
export class ExampleDetailsComponent implements OnInit {

  constructor(private exampleHttpService: ExampleHttpService,
              private route: ActivatedRoute,
              private _location: Location) {
  }

  private id: number = this.route.snapshot.params.id;
  public example: ExampleDetailsModel;

  goBack() {
    this._location.back();
  }

  getExamples() {

    return this.exampleHttpService.getExampleById(this.id).subscribe(data => this.example = data);
  }


  ngOnInit() {
    this.getExamples();
  }

}
