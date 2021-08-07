import {Capitan} from "./Capitan";
import {Shuttle} from "./Shuttle";

export interface Team {
  id: number;
  name: String;
  capitan: Capitan;
  shuttle: Shuttle;
}
