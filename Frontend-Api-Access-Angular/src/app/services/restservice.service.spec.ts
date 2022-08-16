import { TestBed } from '@angular/core/testing';

import { RESTserviceService } from './restservice.service';

describe('RESTserviceService', () => {
  let service: RESTserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RESTserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
