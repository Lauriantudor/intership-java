import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditpartnerComponent } from './editpartner.component';

describe('EditpartnerComponent', () => {
  let component: EditpartnerComponent;
  let fixture: ComponentFixture<EditpartnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditpartnerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditpartnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
