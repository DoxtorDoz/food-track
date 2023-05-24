import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BloqueMeriendaComponent } from './bloque-merienda.component';

describe('BloqueMeriendaComponent', () => {
  let component: BloqueMeriendaComponent;
  let fixture: ComponentFixture<BloqueMeriendaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BloqueMeriendaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BloqueMeriendaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
