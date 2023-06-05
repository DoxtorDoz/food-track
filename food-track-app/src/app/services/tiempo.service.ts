import { Injectable } from '@angular/core';
import axios from 'axios';
import * as cheerio from 'cheerio';

@Injectable({
  providedIn: 'root'
})
export class TiempoService {

  private url = 'api/almeria-almeria-es0am0013.html';

  constructor() { }

  async getWeatherData(): Promise<string> {
    try {
      const response = await axios.get(this.url);
      const html = response.data;
      const $ = cheerio.load(html);

      const tiempo = $('.temp .tmp').text().trim();
      const maxima = $('.info .item:nth-child(1) .txt').text().trim();
      const lluvia = $('.info .item:nth-child(2) .txt').text().trim();
      const a = $('.info .item:nth-child(3) .txt').text().trim();
      const salidaSol = $('.info .item:nth-child(4) .txt').text().trim();
      const puestaSol = $('.info .item:nth-child(5) .txt').text().trim();
      const HorasDeSol = $(' .info .item:nth-child(6) .txt').text().trim();

      const htmlOutput = `
        Tiempo en Almeria
        <br>
        Temp: ${tiempo}
        <br>
        <br>
        ${a}
        <br>
        ${lluvia}
      `;

      return htmlOutput;
    } catch (error) {
      console.log('Error al obtener la página:', error);
      return '';
    }
  }
}
