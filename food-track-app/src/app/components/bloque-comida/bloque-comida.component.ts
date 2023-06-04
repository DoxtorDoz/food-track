import { Component , OnInit, Input} from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-bloque-comida',
  templateUrl: './bloque-comida.component.html',
  styleUrls: ['./bloque-comida.component.sass']
})
export class BloqueComidaComponent implements OnInit{

  //tipoComida!: string;
  @Input() tipoComida!: string;

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.tipoComida = params.get('tipoComida') ?? '';
      console.log(this.tipoComida);
    });
  }

}
