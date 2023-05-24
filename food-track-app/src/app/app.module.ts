import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BloqueDesayunoComponent } from './components/bloque-desayuno/bloque-desayuno.component';
import { BloqueComidaComponent } from './components/bloque-comida/bloque-comida.component';
import { BloqueMeriendaComponent } from './components/bloque-merienda/bloque-merienda.component';
import { BloqueCenaComponent } from './components/bloque-cena/bloque-cena.component';
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    BloqueDesayunoComponent,
    BloqueComidaComponent,
    BloqueMeriendaComponent,
    BloqueCenaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
