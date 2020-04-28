import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vote } from '../model/vote';

@Injectable({
  providedIn: 'root'
})
export class VotingHttpService {

  constructor(private http: HttpClient) {
  }

  public vote(vote: Vote): Observable<any> {
    return this.http
      .post(`api/votes`, vote, {responseType: 'text'});
  }

  // public register(electionAreaId: number): Observable<any> {
  //   return this.http.get(`api/elections/election-area/${electionAreaId}/register`, {responseType: 'text'});
  // }
}
