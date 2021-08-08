import {Team} from "./Team";
import {PlanetStatus} from "./PlanetStatus";

export interface Planet {
  id: number;
  description: string;
  name: string;
  image: string;
  status: PlanetStatus;
  severity?: string;
  team: Team;
  robots?: string[];
}
