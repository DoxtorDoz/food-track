import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { AppComponent } from './app.component';
import { BloqueComidaComponent } from './components/bloque-comida/bloque-comida.component';
import { AppRoutingModule } from './app-routing.module';
import { MainComponent } from './components/main/main.component';
import { MenuVerticalComponent } from './components/menu-vertical/menu-vertical.component';
import { HttpClientModule } from '@angular/common/http';
import { BuscadorAlimentosComponent } from './components/buscador-alimentos/buscador-alimentos.component';
import { FilterPipe } from './components/buscador-alimentos/filter.pipe';
import { ComidaService } from './services/comida.service';
import { VistaDiaComponent } from './components/vista-dia/vista-dia.component';
import { TiempoService } from './services/tiempo.service';


@NgModule({
  declarations: [
    AppComponent,
    BloqueComidaComponent,
    MainComponent,
    MenuVerticalComponent,
    BuscadorAlimentosComponent,
    FilterPipe,
    VistaDiaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [ComidaService, TiempoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
