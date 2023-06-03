import { Component } from '@angular/core';
import { OpenFoodFactsService } from '../../services/open-food-facts.service';
import { BackendService } from 'src/app/services/backend.service';

@Component({
  selector: 'app-bloque-desayuno',
  templateUrl: './bloque-desayuno.component.html',
  styleUrls: ['./bloque-desayuno.component.sass']
})
export class BloqueDesayunoComponent {
  constructor(private openFoodFactsService: OpenFoodFactsService, backendService: BackendService) { }

  ngOnInit() {
    //this.obtenerDatos();
  }



}
