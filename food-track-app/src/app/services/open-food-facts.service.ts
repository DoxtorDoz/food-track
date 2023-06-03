import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OpenFoodFactsService {
  private apiUrl = 'https://world.openfoodfacts.org/api/17';

  constructor(private http: HttpClient) { }

  getProduct(barcode: string) {
    return this.http.get(`${this.apiUrl}/product/${barcode}.json`);
  }

  getNutritionalInformation(barcode: string) {
    return this.http.get(`${this.apiUrl}/product/${barcode}/nutriments.json`);
  }

  getAllProducts() {
    //const headers = new HttpHeaders().set('Food-Track-App', 'Angular - Version 1.0');
    return this.http.get(`https://es.openfoodfacts.org?json=true`);
  }


}
