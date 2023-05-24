import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BloqueCenaComponent } from './bloque-cena.component';

describe('BloqueCenaComponent', () => {
  let component: BloqueCenaComponent;
  let fixture: ComponentFixture<BloqueCenaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BloqueCenaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BloqueCenaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
