import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { ModalFacadeService } from '../service/modal-facade.service';
import { LoginService } from '../service/login.service';
import { ErrorMessageMap } from '../error/error-message.map';

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {

  constructor(private loginService: LoginService,
              private modalFacadeService: ModalFacadeService) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(request).pipe(
      catchError(err => {
        this.handleError(err);
        return throwError('error');
      })
    );
  }

  private handleError(httpErrorResponse: HttpErrorResponse): void {
    if ([401, 403].includes(httpErrorResponse.status)) {
      // todo better 401, 403 error handling on backend
      this.showErrorDialog(ErrorMessageMap.get('E001').message);
    } else {
      const error = httpErrorResponse.error;
      const code = error.code != null ? error.code : 'default';
      this.showErrorDialog(ErrorMessageMap.get(code).message);
    }
  }

  private showErrorDialog(message: string): void {
    this.modalFacadeService.openMessageDialog(message)
      .afterClosed()
      .subscribe(_ => this.loginService.logout());
  }
}
