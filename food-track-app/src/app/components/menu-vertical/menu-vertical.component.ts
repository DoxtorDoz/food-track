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

  constructor(private backendService: BackendService) { }

  ngOnInit() {
    this.backendService.getDias().subscribe(
      (diasFromApi) => {
        this.dias = diasFromApi;
      },
      (error) => {
        console.error(error);
      }
    );


    this.backendService.getDias().subscribe(
      (response) => {
        console.log(response);  // Aquí estás imprimiendo lo que te devuelve el backend
        this.dias = response._embedded.dias;
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
