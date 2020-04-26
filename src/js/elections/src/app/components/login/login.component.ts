import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../../core/service/login.service';
import { LoginData } from '../../core/model/login-data';
import { catchError, tap } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { RegistrationHttpService } from '../../core/http/registration-http.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private loginService: LoginService,
              private registrationService: RegistrationHttpService,
              private router: Router) {
  }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      login: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  login(): void {
    if (this.loginForm.valid) {
      this.loginService.login(this.buildLoginData());
      this.loginService.isLogin$().subscribe(isLogin => {
        if (isLogin) {
          this.router.navigate(['voting']);
        }
      });
    }
  }

  register(): void {
    if (this.loginForm.valid) {
      this.registrationService.register(this.buildLoginData())
        .pipe(
          tap(_ => {
            this.login();
          }),
          // TODO add error interceptor
          catchError(err => {
            console.error(err);
            return throwError(err);
          })
        )
        .subscribe();
    }
  }

  private buildLoginData(): LoginData {
    return {login: this.loginForm.value.login, password: this.loginForm.value.password};
  }
}
