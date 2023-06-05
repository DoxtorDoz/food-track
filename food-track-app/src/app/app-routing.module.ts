import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { BloqueComidaComponent } from './components/bloque-comida/bloque-comida.component';

import { MainComponent } from './components/main/main.component';
import { AppComponent } from './app.component';
import { VistaDiaComponent } from './components/vista-dia/vista-dia.component';


const routes: Routes = [
  { path: '', redirectTo: '/main', pathMatch: 'full' }, // Redirige a la ruta principal
  { path: 'main', component: MainComponent },
  { path: 'comida/:tipoComida', component: BloqueComidaComponent },
  { path: 'dia/:id', component: VistaDiaComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
