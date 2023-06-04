import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { BloqueDesayunoComponent } from './components/bloque-desayuno/bloque-desayuno.component';
import { BloqueComidaComponent } from './components/bloque-comida/bloque-comida.component';
import { BloqueMeriendaComponent } from './components/bloque-merienda/bloque-merienda.component';
import { BloqueCenaComponent } from './components/bloque-cena/bloque-cena.component';
import { MainComponent } from './components/main/main.component';
import { AppComponent } from './app.component';



// const routes: Routes = [
//   { path: '', redirectTo: '/main', pathMatch: 'full' }, // Redirige a la ruta principal
//   { path: 'main', component: MainComponent },
//   { path: 'desayuno', component: BloqueComidaComponent },
//   { path: 'comida', component: BloqueComidaComponent },
//   { path: 'merienda', component: BloqueComidaComponent },
//   { path: 'cena', component: BloqueComidaComponent },
// ];


const routes: Routes = [
  { path: '', redirectTo: '/main', pathMatch: 'full' }, // Redirige a la ruta principal
  { path: 'main', component: MainComponent },
  { path: 'comida/:tipoComida', component: BloqueComidaComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})


// @NgModule({
//   declarations: [],
//   imports: [
//     CommonModule
//   ]
// })
export class AppRoutingModule { }
