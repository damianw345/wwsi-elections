export interface ElectionArea {
  electionAreaId: number;
  electionArea: string;
  area: string;
  counties: Counties;
}

export interface Counties {
  countyCity: string;
  list: string[];
}
