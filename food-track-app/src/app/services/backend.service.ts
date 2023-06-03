import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class BackendService {
  private baseUrl = 'http://localhost:8080/api'; // Reemplaza con la URL base de tu backend

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  obtenerDatos() {
    return this.http.get(`${this.baseUrl}/datos`);
  }

  enviarDatos(datos: any) {
    return this.http.post(`${this.baseUrl}/datos`, datos);
  }

  // Otros métodos para interactuar con tu backend


}
