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

  fechaActual: string = '';


  ngOnInit() {
    const fecha = new Date();
    const dia = fecha.getDate();
    const mes = fecha.getMonth() + 1;
    const anio = fecha.getFullYear();
    this.fechaActual = `${dia < 10 ? '0' + dia : dia}/${mes < 10 ? '0' + mes : mes}/${anio}`;
  }





  constructor(private comidaService: ComidaService, private router: Router) {}

  seleccionarComida(tipoComida: string) {
    this.comidaService.setTipoComida(tipoComida);
    this.router.navigate(['/comida', tipoComida]);
  }


}
