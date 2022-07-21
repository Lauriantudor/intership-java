import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewpartnerComponent } from './viewpartner.component';

describe('ViewpartnerComponent', () => {
  let component: ViewpartnerComponent;
  let fixture: ComponentFixture<ViewpartnerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewpartnerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewpartnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
