import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { Dia, Comida } from '../models/dia';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class BackendService {
  private baseUrl = 'http://localhost:8080/api'; // Reemplaza con la URL base de tu backend

  // Cambiamos diaActual a BehaviorSubject para manejar los cambios de forma reactiva
  private diaActual = new BehaviorSubject<Dia | undefined>(undefined);




  getDiaActual(): Observable<Dia | undefined> {
    return this.diaActual.asObservable();
  }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) {
    //this.crearDiaVacio().subscribe();
    console.log(this.diaActual);
  }

  obtenerTodosLosDias(): Observable<Dia[]> {
    return this.http.get<Dia[]>(`${this.baseUrl}/dias/todosLosDias`);
  }

  crearDia(nuevoDia: Dia): Observable<Dia> {
    return this.http.post<Dia>(`${this.baseUrl}/dias/crearDia`, nuevoDia, this.httpOptions);
  }

  obtenerDiaPorId(diaId: number): Observable<Dia> {
    return this.http.get<Dia>(`${this.baseUrl}/dias/${diaId}`);
  }

  crearComida(diaId: number, nuevaComida: Comida): Observable<Comida> {
    return this.http.post<Comida>(`${this.baseUrl}/dias/${diaId}/crearComida`, nuevaComida, this.httpOptions);
    console.log(nuevaComida);
  }

  enviarDatos(data: any): Observable<any> {
    // Realizar una solicitud HTTP POST al backend
    // y enviar los datos en el cuerpo de la solicitud
    return this.http.post('/api/comidas', data);
  }

  crearDiaVacio(): Observable<Dia> {
    // Inicializar un nuevo objeto Dia con valores predeterminados
    const nuevoDia: Dia = {
      id: 0, // Este valor debería ser ignorado por el backend si está utilizando una estrategia de generación de identidad
      fecha: new Date(), // Configura la fecha para el día actual
      totalCalorias: 0,
      comidas: []
    };

    // Enviar el nuevoDia al backend para ser almacenado en la base de datos
    return this.crearDia(nuevoDia).pipe(
      tap(dia => this.diaActual.next(dia)) // actualiza el diaActual en el BehaviorSubject
    );
  }

//   actualizarComida(diaId: number, comidaId: number, comida: Comida): Observable<Comida> {
//     return this.http.put<Comida>(`${this.baseUrl}/dias/${diaId}/actualizarComida/${comidaId}`, comida, this.httpOptions);
// }

getDias(): Observable<any> {
  return this.http.get<any>(`${this.baseUrl}/dias`);
}

getDia(id: string): Observable<Dia> {
  return this.http.get<Dia>(`${this.baseUrl}/dias/${id}`);
}


}
