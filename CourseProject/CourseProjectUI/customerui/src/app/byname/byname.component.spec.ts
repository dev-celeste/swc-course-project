import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BynameComponent } from './byname.component';

describe('BynameComponent', () => {
  let component: BynameComponent;
  let fixture: ComponentFixture<BynameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BynameComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BynameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
