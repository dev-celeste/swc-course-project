import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BynumberComponent } from './bynumber.component';

describe('BynumberComponent', () => {
  let component: BynumberComponent;
  let fixture: ComponentFixture<BynumberComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BynumberComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BynumberComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
