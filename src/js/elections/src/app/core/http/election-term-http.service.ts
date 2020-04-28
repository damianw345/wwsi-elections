import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ElectionTerm } from '../model/election-term';

@Injectable({
  providedIn: 'root'
})
export class ElectionTermHttpService {

  constructor(private http: HttpClient) {
  }

  public fetchElectionTerms(): Observable<ElectionTerm[]> {
    return this.http
      .get<ElectionTerm[]>(`api/elections/terms`);
  }
}
