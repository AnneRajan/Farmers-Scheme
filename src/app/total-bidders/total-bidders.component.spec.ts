import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TotalBiddersComponent } from './total-bidders.component';

describe('TotalBiddersComponent', () => {
  let component: TotalBiddersComponent;
  let fixture: ComponentFixture<TotalBiddersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TotalBiddersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TotalBiddersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
