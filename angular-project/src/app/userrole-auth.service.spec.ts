import { TestBed } from '@angular/core/testing';

import { UserroleAuthService } from './userrole-auth.service';

describe('UserroleAuthService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserroleAuthService = TestBed.get(UserroleAuthService);
    expect(service).toBeTruthy();
  });
});
