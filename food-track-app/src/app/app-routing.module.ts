import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes } from '@angular/router';
import { BloqueDesayunoComponent } from './components/bloque-desayuno/bloque-desayuno.component';
import { BloqueComidaComponent } from './components/bloque-comida/bloque-comida.component';
import { BloqueMeriendaComponent } from './components/bloque-merienda/bloque-merienda.component';
import { BloqueCenaComponent } from './components/bloque-cena/bloque-cena.component';
import { MainComponent } from './components/main/main.component';
import { AppComponent } from './app.component';


const routes: Routes = [
  {
    path: '',
    component: AppComponent,
    children: [
      { path: 'main', component: MainComponent},
      { path: 'desayuno', component: BloqueDesayunoComponent },
      { path: 'comida', component: BloqueComidaComponent },
      { path: 'merienda', component: BloqueMeriendaComponent },
      { path: 'cena', component: BloqueCenaComponent },
      { path: '', redirectTo: 'desayuno', pathMatch: 'full' } // Ruta por defecto dentro de AppComponent
    ]
  }
];


@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class AppRoutingModule { }
