import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FollowGymatesComponent } from './follow-gymates.component';

describe('FollowGymatesComponent', () => {
  let component: FollowGymatesComponent;
  let fixture: ComponentFixture<FollowGymatesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FollowGymatesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FollowGymatesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
