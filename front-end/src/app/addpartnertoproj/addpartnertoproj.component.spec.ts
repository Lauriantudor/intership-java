import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddpartnertoprojComponent } from './addpartnertoproj.component';

describe('AddpartnertoprojComponent', () => {
  let component: AddpartnertoprojComponent;
  let fixture: ComponentFixture<AddpartnertoprojComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddpartnertoprojComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddpartnertoprojComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
