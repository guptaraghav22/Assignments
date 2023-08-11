import { TestBed } from '@angular/core/testing';

import { RegisterReviewService } from './register-review.service';

describe('RegisterReviewService', () => {
  let service: RegisterReviewService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegisterReviewService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
