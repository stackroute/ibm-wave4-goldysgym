import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomecomponentComponent } from './homecomponent.component';

describe('HomecomponentComponent', () => {
  let component: HomecomponentComponent;
  let fixture: ComponentFixture<HomecomponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomecomponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomecomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
