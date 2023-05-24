import { Component } from '@angular/core';
import { OpenFoodFactsService } from '../../open-food-facts.service';
import { FilterPipe } from '../buscador-alimentos/filter.pipe'

@Component({
  selector: 'app-buscador-alimentos',
  templateUrl: './buscador-alimentos.component.html',
  styleUrls: ['./buscador-alimentos.component.sass'],
  providers: [FilterPipe]
})
 export class BuscadorAlimentosComponent {
  products: any[] = [];
  filteredProducts: any[] = [];
  searchTerm: string = '';

  onSearchInput(event: any) {
    this.searchTerm = event.target.value;
    this.filterProducts();
  }




  constructor(private openFoodFactsService: OpenFoodFactsService) { }

  ngOnInit(): void {
    this.openFoodFactsService.getAllProducts().subscribe(
      (response: any) => {
        this.products = response.products;
        this.filteredProducts = this.products; // Inicialmente mostrar todos los productos
      },
      (error) => {
        console.error(error);
      }
    );
  }

  filterProducts() {
    this.filteredProducts = this.products.filter((product: any) => {
      // Filtrar por el término de búsqueda en el nombre o marca del producto
      return (
        product.product_name.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
        product.brands.toLowerCase().includes(this.searchTerm.toLowerCase())
      );
    });
  }



}
