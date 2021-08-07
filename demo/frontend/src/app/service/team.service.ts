import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Team} from "../model/Team";

@Injectable({
  providedIn: 'root'
})
export class TeamService {
  private baseUrl = "http://localhost:8080/team";

  constructor(private http: HttpClient) {
  }

  getTeams(): Promise<Team[]>{
    return this.http.get<any>(this.baseUrl  + '/list')
      .toPromise()
  }
}
