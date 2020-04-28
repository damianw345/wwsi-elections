import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Candidate } from '../model/candidate';

@Injectable({
  providedIn: 'root'
})
export class FindCandidatesHttpService {

  constructor(private http: HttpClient) {
  }

  public fetchCandidates(electionTermId: number, electionAreaId: number, committeeId: number): Observable<Candidate[]> {
    return this.http
      .get<Candidate[]>(`api/elections/candidates?electionTermId=${electionTermId}&electionAreaId=${electionAreaId}&committeeId=${committeeId}`);
  }

}
