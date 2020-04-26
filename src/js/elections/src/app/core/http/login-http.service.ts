import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginHttpService {

  constructor(private httpClient: HttpClient) {
  }

  login(base64LoginData: string): Observable<Response> {
    let authHeader = new HttpHeaders({
      'Authorization': base64LoginData
    });
    return this.httpClient.get<Response>('api/users/login', {headers: authHeader});
  }
}
