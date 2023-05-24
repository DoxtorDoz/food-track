import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BloqueDesayunoComponent } from './bloque-desayuno.component';

describe('BloqueDesayunoComponent', () => {
  let component: BloqueDesayunoComponent;
  let fixture: ComponentFixture<BloqueDesayunoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BloqueDesayunoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BloqueDesayunoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
