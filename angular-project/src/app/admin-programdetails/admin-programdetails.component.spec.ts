import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminProgramdetailsComponent } from './admin-programdetails.component';

describe('AdminProgramdetailsComponent', () => {
  let component: AdminProgramdetailsComponent;
  let fixture: ComponentFixture<AdminProgramdetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminProgramdetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminProgramdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
