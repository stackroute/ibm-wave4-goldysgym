import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EnrolltestComponent } from './enrolltest.component';

describe('EnrolltestComponent', () => {
  let component: EnrolltestComponent;
  let fixture: ComponentFixture<EnrolltestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EnrolltestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EnrolltestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
