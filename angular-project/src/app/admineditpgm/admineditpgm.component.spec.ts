import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdmineditpgmComponent } from './admineditpgm.component';

describe('AdmineditpgmComponent', () => {
  let component: AdmineditpgmComponent;
  let fixture: ComponentFixture<AdmineditpgmComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdmineditpgmComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdmineditpgmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
