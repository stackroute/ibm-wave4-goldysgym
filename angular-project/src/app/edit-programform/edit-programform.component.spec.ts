import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditProgramformComponent } from './edit-programform.component';

describe('EditProgramformComponent', () => {
  let component: EditProgramformComponent;
  let fixture: ComponentFixture<EditProgramformComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditProgramformComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditProgramformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
