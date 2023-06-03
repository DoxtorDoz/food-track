import { Component } from '@angular/core';
import { OpenFoodFactsService } from '../../services/open-food-facts.service';


@Component({
  selector: 'app-buscador-alimentos',
  templateUrl: './buscador-alimentos.component.html',
  styleUrls: ['./buscador-alimentos.component.sass'],

})
 export class BuscadorAlimentosComponent {

  expandedProductId: number | null = null;
  products: any[] = [];
  filteredProducts: any[] = [];
  searchTerm: string = '';

  onSearchInput(event: any) {
    this.searchTerm = event.target.value;
    console.log(this.searchTerm); // Agrega esta línea para verificar el valor de searchTerm
    this.filterProducts();
  }

  expandProduct(productId: number) {
    if (this.expandedProductId === productId) {
      // Si el producto ya está expandido, lo contraemos al hacer clic nuevamente
      this.expandedProductId = null;
    } else {
      // Si el producto no está expandido, lo expandimos al hacer clic
      this.expandedProductId = productId;
    }
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
        product.product_name?.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
        product.brands.toLowerCase().includes(this.searchTerm.toLowerCase())
      );
    });
  }

}
