import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginData } from '../model/login-data';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegistrationHttpService {

  private endpoint = 'api/users/register';

  constructor(private http: HttpClient) {
  }

  public register(loginData: LoginData): Observable<Response> {
    return this.http.post<Response>(this.endpoint, {...loginData});
  }
}
