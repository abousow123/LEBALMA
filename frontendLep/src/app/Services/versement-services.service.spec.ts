import { TestBed } from '@angular/core/testing';

import { VersementServicesService } from './versement-services.service';

describe('VersementServicesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: VersementServicesService = TestBed.get(VersementServicesService);
    expect(service).toBeTruthy();
  });
});
