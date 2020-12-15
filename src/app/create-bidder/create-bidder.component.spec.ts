import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateBidderComponent } from './create-bidder.component';

describe('CreateBidderComponent', () => {
  let component: CreateBidderComponent;
  let fixture: ComponentFixture<CreateBidderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateBidderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateBidderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
