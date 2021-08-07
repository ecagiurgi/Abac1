import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PlanetComponent} from "./planet-component/planet-component.component";
import {CreatePlanetComponent} from "./create-planet/create-planet.component";

const routes: Routes = [
  {path: '', redirectTo: 'planets', pathMatch: 'full'},
  {path: 'planets', component: PlanetComponent},
  {path: 'add', component: CreatePlanetComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
