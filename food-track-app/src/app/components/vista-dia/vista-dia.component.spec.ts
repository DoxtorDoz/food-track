import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VistaDiaComponent } from './vista-dia.component';

describe('VistaDiaComponent', () => {
  let component: VistaDiaComponent;
  let fixture: ComponentFixture<VistaDiaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VistaDiaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VistaDiaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
