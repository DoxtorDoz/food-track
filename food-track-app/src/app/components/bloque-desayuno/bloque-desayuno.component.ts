import { Component } from '@angular/core';
import { OpenFoodFactsService } from '../../open-food-facts.service';

@Component({
  selector: 'app-bloque-desayuno',
  templateUrl: './bloque-desayuno.component.html',
  styleUrls: ['./bloque-desayuno.component.sass']
})
export class BloqueDesayunoComponent {
  constructor(private openFoodFactsService: OpenFoodFactsService) { }

  ngOnInit() { }

}
