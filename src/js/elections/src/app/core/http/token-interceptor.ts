import {
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
  HttpResponse
} from '@angular/common/http';
import { AuthService } from '../service/auth.service';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Router } from '@angular/router';
import { Injectable } from '@angular/core';
import { ModalFacadeService } from '../service/modal-facade.service';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  constructor(private auth: AuthService,
              private router: Router,
              private  modalFacadeService: ModalFacadeService) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    // add authorization header to the request with jwt token if available
    const token = this.auth.getTokenFromStorage();
    if (token) {
      request = request.clone({
        setHeaders: {Authorization: token}
      });
    }

    // add response handling
    return next.handle(request)
      .pipe(
        tap((event: HttpEvent<any>) => {
          if (event instanceof HttpResponse) {
            // custom response handling
          }
        }, (err: any) => {
          if (err instanceof HttpErrorResponse) {
            if (err.status >= 400) {
              this.auth.clearToken();
              this.router.navigate(['']);
              this.modalFacadeService.openMessageDialog('Nastąpił błąd aplikacji. Zostałeś wylogowany');
            }
          }
        })
      );
  }
}
