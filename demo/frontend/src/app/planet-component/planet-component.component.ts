import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {ConfirmationService, MenuItem, Message} from "primeng/api";
import {PlanetService} from "../service/planet.service";
import {TeamService} from "../service/team.service";
import {RobotService} from "../service/robot.service";
import {Planet} from "../model/Planet";
import {Team} from "../model/Team";
import {PlanetStatus} from "../model/PlanetStatus";
import {PlanetForUpdate} from "../model/PlanetForUpdate";
import {Status} from "../model/Status";

@Component({
  selector: 'app-planet-component',
  templateUrl: './planet-component.component.html',
  styleUrls: ['./planet-component.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class PlanetComponent implements OnInit {

  planets !: Planet[];
  items !: MenuItem[];
  teams !: Team[];
  selectedTeam !: number;
  selectedItem !: Planet;


  message: Message[] = [];


  constructor(private planetService: PlanetService,
              private robotService: RobotService,
              private confirmationService: ConfirmationService,
              private teamService: TeamService) {
  }

  ngOnInit() {
    this.loadPlanetData();
    this.items = [
      {label: 'OK', icon: 'pi pi-check', command: () => {this.updateStatus(PlanetStatus.OK);}},
      {label: 'NOK', icon: 'pi pi-times', command: () => {this.updateStatus(PlanetStatus.NOK);}},
      {label: 'EN ROUTE', icon: 'pi pi-spinner', command: () => {this.updateStatus(PlanetStatus.EN_ROUTE);}},
      {label: 'TODO', icon: 'pi pi-lock', command: () => {this.updateStatus(PlanetStatus.TODO);}},
      {separator: true},
      {label: 'Assign Team', icon: 'pi pi-cog', command: () => {this.updateTeam();}}
    ];
    this.loadTeamData();
  }

  loadPlanetData() {
    this.planets = [];
    this.planetService.getPlanets().then(planets => {
      this.getRobotsForPlanets(planets);
      this.planets = this.planets.sort((a,b) => (a.id - b.id));
    });
  }

  loadTeamData() {
    this.teams = [];
    this.teamService.getTeams().then(teams => {
      this.teams = teams;
    });
  }

  private getRobotsForPlanets(planets: Planet[]) {
    let planetDetails: Planet[] = [];
    planets.forEach(p => {
      this.robotService.getRobots(p.team.id).then(robots => {
        let item: Planet = p;
        item.robots = robots.map(e => e.name);
        planetDetails.push(item);
        this.planets = [...planetDetails];
      });
    });
  }

  public severity(value: any): any {
    switch (value) {
      case "OK":
        return Status.OK;
      case "NOK":
        return Status.NOK;
      case "TODO":
        return Status.TODO;
      case "EN_ROUTE":
        return Status.EN_ROUTE;
    }
  }

  public setIcon(value: any): string {
    switch (value) {
      case "OK":
        return "pi pi-check-circle";
      case "NOK":
        return "pi pi-times-circle";
      case "TODO":
        return "pi pi-lock";
      case "EN_ROUTE":
        return "pi pi-spinner";
      default:
        return "";
    }
  }

  updateStatus(status : PlanetStatus) {
    let item: PlanetForUpdate = {status: status, id: this.selectedItem?.id};
    this.planetService.updatePlanet(item).then((res) => {
      let updateItem = this.planets.find(el => el.id === res.id)!;
      this.planets[this.planets.indexOf(updateItem)].status = res.status;
    });
  }

  updateTeam() {
    this.confirmationService.confirm({
      message: 'Please assign team to visit the planet',
      header: 'Assign Team',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.assignTeam();
      },
      reject: () => {}
    });
  }

  assignTeam() {
    let item: PlanetForUpdate = {id: this.selectedItem?.id, teamId: this.selectedTeam};
    this.planetService.updatePlanet(item).then((res) => {
      this.message = [{severity:'info', summary:'Confirmed', detail:'Team was updated. Good luck!'}];
      let updateItem = this.planets.find(el => el.id === res.id)!;
      this.planets[this.planets.indexOf(updateItem)].team = res.team;
    });
  }

  setActiveItem(planet: Planet) {
    this.selectedItem = planet;
  }

}
