import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminMyprogramsComponent } from './admin-myprograms.component';

describe('AdminMyprogramsComponent', () => {
  let component: AdminMyprogramsComponent;
  let fixture: ComponentFixture<AdminMyprogramsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminMyprogramsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminMyprogramsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
