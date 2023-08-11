import { TestBed } from '@angular/core/testing';

import { UsernameserviceService } from './usernameservice.service';

describe('UsernameserviceService', () => {
  let service: UsernameserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UsernameserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
