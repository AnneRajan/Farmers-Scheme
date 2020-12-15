import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FarmerlandingpageComponent } from './farmerlandingpage.component';

describe('FarmerlandingpageComponent', () => {
  let component: FarmerlandingpageComponent;
  let fixture: ComponentFixture<FarmerlandingpageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FarmerlandingpageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FarmerlandingpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
