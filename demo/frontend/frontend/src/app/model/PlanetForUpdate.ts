import {PlanetStatus} from "./PlanetStatus";

export interface PlanetForUpdate {
  id: number;
  status?: PlanetStatus;
  teamId?: number;
}
