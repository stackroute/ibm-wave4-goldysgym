import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserMyprogramsComponent } from './user-myprograms.component';

describe('UserMyprogramsComponent', () => {
  let component: UserMyprogramsComponent;
  let fixture: ComponentFixture<UserMyprogramsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserMyprogramsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserMyprogramsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
