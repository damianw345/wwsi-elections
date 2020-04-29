import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { LoginData } from '../model/login-data';
import { map } from 'rxjs/operators';
import { LoginHttpService } from '../http/login-http.service';
import { AuthService } from './auth.service';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private currentUserSub = new BehaviorSubject<LoginData>(null);
  currentUser$: Observable<LoginData> = this.currentUserSub.asObservable();

  constructor(private loginHttpService: LoginHttpService,
              private authService: AuthService,
              private router: Router) {
  }

  login(loginData: LoginData): void {

    let token = btoa(`${loginData.login}:${loginData.password}`);

    this.loginHttpService
      .login(token)
      .subscribe(_ => {
        this.authService.setTokenInStorage(token);
        this.currentUserSub.next(loginData);
      });
  }

  logout(): void {
    this.currentUserSub.next(null);
    this.authService.clearToken();
    this.router.navigate(['']);
  }

  isLogin$(): Observable<boolean> {
    return this.currentUser$.pipe(
      map(currentUser => !!currentUser)
    );
  }
}
