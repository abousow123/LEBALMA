import { TestBed } from '@angular/core/testing';

import { PretServicesService } from './pret-services.service';

describe('PretServicesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PretServicesService = TestBed.get(PretServicesService);
    expect(service).toBeTruthy();
  });
});
