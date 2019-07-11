import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ExampleModel} from "../../example/example.model";
import {ExampleDetailsModel} from "../../example/example-details/example-details.model";

@Injectable({
  providedIn: 'root'
})
export class ExampleHttpService {

  constructor(private httpClient: HttpClient) {
  }

  getExamples() {
    return this.httpClient.get<ExampleModel[]>("api/examples");
  }

  getExampleById(id: number) {
    return this.httpClient.get<ExampleDetailsModel>("api/examples/" + id);
  }

  saveExample(exampleDetails: ExampleDetailsModel) {
    let body = {
      name: exampleDetails.name,
      imageUrl: exampleDetails.imageUrl,
      email: exampleDetails.email,
      price: exampleDetails.price
    };
    return this.httpClient.post<ExampleModel>('/api/examples', body);
  }
}
