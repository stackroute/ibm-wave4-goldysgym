import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubscriptionviewComponent } from './subscriptionview.component';

describe('SubscriptionviewComponent', () => {
  let component: SubscriptionviewComponent;
  let fixture: ComponentFixture<SubscriptionviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SubscriptionviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubscriptionviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
