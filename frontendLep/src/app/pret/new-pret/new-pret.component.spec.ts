import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewPretComponent } from './new-pret.component';

describe('NewPretComponent', () => {
  let component: NewPretComponent;
  let fixture: ComponentFixture<NewPretComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewPretComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewPretComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
