import { Component, OnInit } from '@angular/core';
import { BackendService } from '../../services/backend.service';

@Component({
  selector: 'app-menu-vertical',
  templateUrl: './menu-vertical.component.html',
  styleUrls: ['./menu-vertical.component.sass']
})
export class MenuVerticalComponent implements OnInit{
  constructor(private backendService: BackendService) { }

  ngOnInit() {
    // No queremos crear un día vacío automáticamente al inicializar, vamos a hacerlo por demanda con un botón

  }

  // Esta función será llamada cuando el usuario haga clic en "Crear día"
  crearDia(): void {
    this.backendService.crearDiaVacio().subscribe(
      (nuevoDia) => {
        // Aquí puedes manejar lo que sucede después de que el día ha sido creado.
        // Por ejemplo, puedes actualizar la interfaz de usuario con la información del nuevo día.
        console.log(nuevoDia);
      },
      (error) => {
        // Aquí puedes manejar lo que sucede si ocurre un error al crear el día.
        console.error(error);
      }
    );
  }
}
