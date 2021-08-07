import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Robot} from "../model/Robot";

@Injectable({
  providedIn: 'root'
})
export class RobotService {
  private baseUrl = "http://localhost:8080/robot";

  constructor(private http: HttpClient) {
  }

  getRobots(teamId: number): Promise<Robot[]>{
    return this.http.get<any>(this.baseUrl  + '/listByTeamId', { params: {teamId: teamId}})
      .toPromise()
  }
}
