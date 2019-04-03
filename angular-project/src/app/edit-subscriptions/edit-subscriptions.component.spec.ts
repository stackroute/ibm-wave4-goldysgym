import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditSubscriptionsComponent } from './edit-subscriptions.component';

describe('EditSubscriptionsComponent', () => {
  let component: EditSubscriptionsComponent;
  let fixture: ComponentFixture<EditSubscriptionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditSubscriptionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditSubscriptionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
