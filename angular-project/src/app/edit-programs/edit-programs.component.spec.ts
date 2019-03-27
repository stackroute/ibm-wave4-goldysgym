import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditProgramsComponent } from './edit-programs.component';

describe('EditProgramsComponent', () => {
  let component: EditProgramsComponent;
  let fixture: ComponentFixture<EditProgramsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditProgramsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditProgramsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
