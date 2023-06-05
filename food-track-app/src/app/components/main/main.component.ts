import { Component, Input } from '@angular/core';
import { ComidaService } from 'src/app/services/comida.service';
import { Router } from '@angular/router';
import { TiempoService } from 'src/app/services/tiempo.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.sass']
})
export class MainComponent {
  title = 'Mi Aplicación';

  fechaActual: string = '';
  tiempo!: string;


  constructor(private comidaService: ComidaService, private router: Router, private tiempoService: TiempoService) {}

  async ngOnInit() {
    this.tiempo = await this.tiempoService.getWeatherData();
    console.log("Tiempo"+this.tiempo);
    const fecha = new Date();
    const dia = fecha.getDate();
    const mes = fecha.getMonth() + 1;
    const anio = fecha.getFullYear();
    this.fechaActual = `${dia < 10 ? '0' + dia : dia}/${mes < 10 ? '0' + mes : mes}/${anio}`;
  }







  seleccionarComida(tipoComida: string) {
    this.comidaService.setTipoComida(tipoComida);
    this.router.navigate(['/comida', tipoComida]);
  }


}
