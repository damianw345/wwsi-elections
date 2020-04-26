import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterToOnlineVotingHttpService {

  constructor(private http: HttpClient) {
  }

  public register(electionAreaId: number): Observable<any> {
    return this.http.get(`api/elections/election-area/${electionAreaId}/register`, {responseType: 'text'});
  }
}
