import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {Team} from "../model/Team";
import {PlanetService} from "../service/planet.service";
import {TeamService} from "../service/team.service";
import {PlanetForSave} from "../model/PlanetForSave";
import {Router} from "@angular/router";
import {Message} from "primeng/api";

@Component({
  selector: 'app-create-planet',
  templateUrl: './create-planet.component.html',
  styleUrls: ['./create-planet.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class CreatePlanetComponent implements OnInit {

  teams !: Team[];
  selectedTeam !: number;
  images !: string[];
  selectedImage !: string;

  planetName !: string;
  planetDescription !: string;

  message: Message[] = [];

  constructor(private planetService: PlanetService,
              private teamService: TeamService,
              private router:Router) {
  }

  ngOnInit() {
    this.loadTeamData();
    this.images = [
      "https://img.icons8.com/color/96/000000/venus-planet.png",
      "https://img.icons8.com/color/96/000000/mars-planet.png",
      "https://img.icons8.com/color/96/000000/uranus-planet.png",
      "https://img.icons8.com/color/96/000000/saturn-planet.png",
      "https://img.icons8.com/color/96/000000/jupiter-planet.png",
      "https://img.icons8.com/color/96/000000/mercury-planet.png",
      "https://img.icons8.com/color/96/000000/earth-planet.png"
    ];
  }


  loadTeamData() {
    this.teams = [];
    this.teamService.getTeams().then(teams => {
      this.teams = teams;
    });
  }

  createPlanet() {
    if (this.selectedTeam === undefined || this.planetName === undefined) {
      this.message = [{
        severity: 'error',
        summary: 'Required fields',
        detail: 'Please fill in the name and select a team in order to add a new planet!'
      }];
    } else {
      let newPlanet: PlanetForSave = {
        name: this.planetName,
        description: this.planetDescription,
        teamId: this.selectedTeam,
        image: this.selectedImage
      };
      this.planetService.savePlanet(newPlanet).then(res => {
        console.log(res)
        this.router.navigate(['/planets']);
      });
    }
  }

  cancel() {
    this.router.navigate(['/planets']);
  }
}
