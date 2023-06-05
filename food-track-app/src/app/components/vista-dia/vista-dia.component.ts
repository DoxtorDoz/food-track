import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BackendService } from '../../services/backend.service';
import { Dia, Comida } from '../../models/dia';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-dia-detalle',
  templateUrl: './vista-dia.component.html',
  styleUrls: ['./vista-dia.component.sass']
})
export class VistaDiaComponent implements OnInit {
  dia: Dia | undefined;
  fecha: Date | undefined;
  totalKcal: number | undefined;
  id: number | undefined;

  constructor(
    private route: ActivatedRoute,
    private backendService: BackendService
  ) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if (id !== null) {
      this.backendService.getDia(+id).subscribe(
        diaFromApi => {
          this.id = diaFromApi.id;
          this.dia = diaFromApi;
          this.fecha = diaFromApi.fecha;
          this.totalKcal = diaFromApi.totalCalorias;
        },
        error => {
          console.error(error);
        }
      );
    } else {
      console.error('No ID parameter in the URL');
    }

  if (id === null) {
    // Redireccionar al usuario a otra página, o mostrar un mensaje de error.
    console.error('ID del día no proporcionado');
    return;
  }
}
}
