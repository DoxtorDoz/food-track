import { Component, Input } from '@angular/core';
import { ComidaService } from 'src/app/services/comida.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.sass']
})
export class MainComponent {
  title = 'Mi Aplicación';


  constructor(private comidaService: ComidaService, private router: Router) {}

  seleccionarComida(tipoComida: string) {
    this.comidaService.setTipoComida(tipoComida);
    this.router.navigate(['/comida', tipoComida]);
  }
}
