import { Component , OnInit} from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-bloque-comida',
  templateUrl: './bloque-comida.component.html',
  styleUrls: ['./bloque-comida.component.sass']
})
export class BloqueComidaComponent implements OnInit{

  tipoComida!: string;

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.tipoComida = params['tipoComida'];
      // Lógica para obtener y mostrar la información según el tipo de comida
    });
  }

}
