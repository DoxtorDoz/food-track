export interface Dia {
  id: number;
  fecha: Date;
  totalCalorias: number;
  comidas: Comida[];
}


export interface Comida {
  //id: number;
  tipoComida: TipoComida;
  totalKcal: number;
  alimentos: Producto[];
}

export enum TipoComida {
  DESAYUNO = 'DESAYUNO',
  COMIDA = 'COMIDA',
  MERIENDA = 'MERIENDA',
  CENA = 'CENA'
}

export interface Producto {
  //id: number;
  nombre: string;
  kcal: number;
}
