import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PlanetComponent} from "./planet-component/planet-component.component";

const routes: Routes = [
  {path: '', redirectTo: 'planets', pathMatch: 'full'},
  {path: 'planets', component: PlanetComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
