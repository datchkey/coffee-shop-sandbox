import {TestBed} from '@angular/core/testing';

import {ExampleHttpService} from './example-http.service';
import {HttpClientModule} from "@angular/common/http";

describe('ExampleHttpService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule]
    })
  });

  it('should be created', () => {
    const service: ExampleHttpService = TestBed.get(ExampleHttpService);
    expect(service).toBeTruthy();
  });
});
