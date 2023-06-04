import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { AppComponent } from './app.component';
import { BloqueDesayunoComponent } from './components/bloque-desayuno/bloque-desayuno.component';
import { BloqueComidaComponent } from './components/bloque-comida/bloque-comida.component';
import { BloqueMeriendaComponent } from './components/bloque-merienda/bloque-merienda.component';
import { BloqueCenaComponent } from './components/bloque-cena/bloque-cena.component';
import { AppRoutingModule } from './app-routing.module';
import { MainComponent } from './components/main/main.component';
import { MenuVerticalComponent } from './components/menu-vertical/menu-vertical.component';
import { HttpClientModule } from '@angular/common/http';
import { BuscadorAlimentosComponent } from './components/buscador-alimentos/buscador-alimentos.component';
import { FilterPipe } from './components/buscador-alimentos/filter.pipe';
import { ComidaService } from './services/comida.service';


@NgModule({
  declarations: [
    AppComponent,
    BloqueDesayunoComponent,
    BloqueComidaComponent,
    BloqueMeriendaComponent,
    BloqueCenaComponent,
    MainComponent,
    MenuVerticalComponent,
    BuscadorAlimentosComponent,
    FilterPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [ComidaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
