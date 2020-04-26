import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ElectionArea } from '../model/election-area';

@Injectable({
  providedIn: 'root'
})
export class ElectionAreaHttpService {

  constructor(private httpClient: HttpClient) {
  }

  fetchElectionAreas(): Observable<ElectionArea[]> {
    return this.httpClient.get<ElectionArea[]>('api/elections/areas');
  }
}
