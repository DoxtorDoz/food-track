import { Component , OnInit, Input} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BackendService } from '../../services/backend.service';
import { Comida, TipoComida, Dia, Producto } from '../../models/dia';
@Component({
  selector: 'app-bloque-comida',
  templateUrl: './bloque-comida.component.html',
  styleUrls: ['./bloque-comida.component.sass']
})
export class BloqueComidaComponent implements OnInit{

  //tipoComida!: string;
  @Input() tipoComida!: string;
  productosSeleccionados: any[] = [];
  expandedProductId: number | null = null;
  diaActual: Dia | undefined;
  comidaActual: Comida | undefined;
  dias: Dia[] = [];



  constructor(private route: ActivatedRoute, private backendService: BackendService) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.tipoComida = params.get('tipoComida') ?? '';
      console.log(this.tipoComida);
    });

    this.backendService.getDias().subscribe((dias: Dia[]) => {
      this.dias = dias;
      this.diaActual = dias[dias.length - 1]; // seleccionamos el último día
    });
  }

  agregarProducto(producto: string) {
    this.productosSeleccionados.push(producto);
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

  guardarTodasLasComidas() {
    this.guardarComida('DESAYUNO');
    this.guardarComida('COMIDA');
    this.guardarComida('MERIENDA');
    this.guardarComida('CENA');
  }


  guardarComida(tipoComida: string) {
    const { totalCalorias} = this.calcularTotales();

    const productosDeApi = this.productosSeleccionados;
    const alimentos: Producto[] = productosDeApi.map(productoApi => {
        return {
            nombre: productoApi.abbreviated_product_name, // O el campo que represente el nombre
            kcal: productoApi.nutriments.energy_100g,
        };
    });

    const comida: Comida = {
      //id: 200,
      tipoComida: TipoComida[tipoComida.toUpperCase() as keyof typeof TipoComida],
      totalKcal: totalCalorias,
      alimentos: alimentos.map(producto => {
        return {
          nombre: producto.nombre,
          kcal: producto.kcal,
        };})
    };

      console.log(comida);

    this.backendService.getDiaActual().subscribe(diaActual => {
      if (diaActual) {
        this.backendService.crearComida(diaActual.id, comida).subscribe(
          (response: Comida) => {
            console.log('Comida guardada:', response);
          },
          (error: any) => {
            console.error('Error al guardar la comida:', error);
          }
        );
      } else {
        console.error('No hay un día actual definido');
      }
      console.log(comida)
    });
  }


  calcularTotales() {
    let totalCalorias = 0;

    for (const product of this.productosSeleccionados) {
      totalCalorias += parseFloat(product.nutriments.energy_100g);
    }

    return {
      totalCalorias,
    };
  }

  // actualizarComida(tipoComida: string) {
  //   const comida: Comida = {
  //     //id: 2,
  //     tipoComida: TipoComida[tipoComida.toUpperCase() as keyof typeof TipoComida],
  //     totalCalorias: 0,
  //     productos: this.productosSeleccionados
  //   };
  //   const diaId = this.diaActual?.id;
  //   //const comidaId = this.comidaActual?.id;

  //   if (diaId !== undefined) {
  //     this.backendService.actualizarComida(diaId, comida).subscribe(
  //       (response: Comida) => {
  //         console.log('Comida actualizada:', response);
  //       },
  //       (error: any) => {
  //         console.error('Error al actualizar la comida:', error);
  //       }
  //     );
  //   } else {
  //     console.error('No se puede actualizar la comida porque diaId o comidaId son indefinidos');
  //   }
  // }



}
