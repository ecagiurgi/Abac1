import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Planet} from "../model/Planet";
import {PlanetForUpdate} from "../model/PlanetForUpdate";

@Injectable({
  providedIn: 'root'
})
export class PlanetService {
  private baseUrl = "http://localhost:8080/planet";

  constructor(private http: HttpClient) {
  }

  getPlanets(): Promise<Planet[]>{
    return this.http.get<any>(this.baseUrl  + '/list')
      .toPromise()
  }

  updatePlanet(planet: PlanetForUpdate): Promise<Planet>{
    return this.http.put<any>(this.baseUrl  + '/update', planet)
      .toPromise()
  }

}
