import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BloqueComidaComponent } from './bloque-comida.component';

describe('BloqueComidaComponent', () => {
  let component: BloqueComidaComponent;
  let fixture: ComponentFixture<BloqueComidaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BloqueComidaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BloqueComidaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
