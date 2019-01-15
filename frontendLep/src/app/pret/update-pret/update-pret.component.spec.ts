import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatePretComponent } from './update-pret.component';

describe('UpdatePretComponent', () => {
  let component: UpdatePretComponent;
  let fixture: ComponentFixture<UpdatePretComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdatePretComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatePretComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
