import { Component, OnInit } from '@angular/core';
import { BackendService } from '../../services/backend.service';
import { Dia } from '../../models/dia';

@Component({
  selector: 'app-menu-vertical',
  templateUrl: './menu-vertical.component.html',
  styleUrls: ['./menu-vertical.component.sass']
})
export class MenuVerticalComponent implements OnInit {
  dias: Dia[] = [];
  diaActual= 0;
  fecha: Date | undefined;
  totalKcal: number | undefined;

  constructor(private backendService: BackendService) { }

  ngOnInit() {
    this.backendService.getDias().subscribe(
      (response) => {
        console.log(response);
        this.dias = response._embedded.dias.map((dia: any) => {
          const urlParts = dia._links.self.href.split('/');
          const id = +urlParts[urlParts.length - 1];  // Convertir a número
          return {
            id: id,
            fecha: dia.fecha,
            totalCalorias: dia.totalKcal,
            comidas: dia.comidas
          };
        });
      },
      (error) => {
        console.error(error);
      }
    );
  }

  crearDia(): void {
    this.backendService.crearDiaVacio().subscribe(
      (nuevoDia) => {
        this.dias.push(nuevoDia);
      },
      (error) => {
        console.error(error);
      }
    );
  }
}
