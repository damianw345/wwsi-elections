import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { LoginData } from '../model/login-data';
import { map } from 'rxjs/operators';
import { LoginHttpService } from '../http/login-http.service';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private currentUserSub = new BehaviorSubject<LoginData>(null);
  currentUser$: Observable<LoginData> = this.currentUserSub.asObservable();

  constructor(private loginHttpService: LoginHttpService,
              private authService: AuthService) {
  }

  login(loginData: LoginData): void {

    let token = `${loginData.login}:${loginData.password}`;

    this.loginHttpService
      .login(btoa(token))
      .subscribe(_ => {
        this.authService.setTokenInStorage(token);
        this.currentUserSub.next(loginData);
      });
  }

  logout(): void {
    this.currentUserSub.next(null);
    this.authService.clearToken();
  }

  isLogin$(): Observable<boolean> {
    return this.currentUser$.pipe(
      map(currentUser => !!currentUser)
    );
  }
}
