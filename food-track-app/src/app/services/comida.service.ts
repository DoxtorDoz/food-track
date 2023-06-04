import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ComidaService {

  private tipoComida!: string;

  setTipoComida(tipo: string) {
    this.tipoComida = tipo;
  }

  getTipoComida() {
    return this.tipoComida;
  }
}
