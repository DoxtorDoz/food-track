import { Component } from '@angular/core';
import { OpenFoodFactsService } from '../../open-food-facts.service';

@Component({
  selector: 'app-bloque-desayuno',
  templateUrl: './bloque-desayuno.component.html',
  styleUrls: ['./bloque-desayuno.component.sass']
})
export class BloqueDesayunoComponent {
  constructor(private openFoodFactsService: OpenFoodFactsService) { }

  ngOnInit() {
    const barcode = ''; // Código de barras del producto que deseas obtener

    // Obtener el producto
    this.openFoodFactsService.getProduct(barcode).subscribe(
      (product: any) => {
        console.log(product); // Ver los datos del producto en la consola
        // Aquí puedes asignar los datos del producto a propiedades del componente
      },
      (error) => {
        console.error(error); // Manejar el error si ocurre
      }
    );

    // Obtener información nutricional del producto
    this.openFoodFactsService.getNutritionalInformation(barcode).subscribe(
      (nutriments: any) => {
        console.log(nutriments); // Ver los datos de la información nutricional en la consola
        // Aquí puedes asignar los datos de la información nutricional a propiedades del componente
      },
      (error) => {
        console.error(error); // Manejar el error si ocurre
      }
    );
  }

}
