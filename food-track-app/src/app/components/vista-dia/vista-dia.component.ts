import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BackendService } from '../../services/backend.service';

@Component({
  selector: 'app-dia-detalle',
  templateUrl: './vista-dia.component.html',
  styleUrls: ['./vista-dia.component.sass']
})
export class VistaDiaComponent implements OnInit {
  dia: any;



  constructor(
    private route: ActivatedRoute,
    private backendService: BackendService
  ) { }

  ngOnInit(): void {
    let id = this.route.snapshot.paramMap.get('id');
    if (id !== null) {
      this.backendService.getDia(id).subscribe((dia: any) => {
        this.dia = dia;
      });
    } else {
      // Maneja el caso en el que id es null
    }

  }
}
