import { TestBed } from '@angular/core/testing';

import { PartnerserviceService } from './partnerservice.service';

describe('PartnerserviceService', () => {
  let service: PartnerserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PartnerserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
