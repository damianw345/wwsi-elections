import { Injectable } from '@angular/core';
import { LOCAL_STORAGE } from '../../const/local-storage';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() {
  }

  getTokenFromStorage(): string | null {
    return localStorage.getItem(LOCAL_STORAGE.TOKEN);
  }

  setTokenInStorage(token: string): void {
    localStorage.setItem(LOCAL_STORAGE.TOKEN, token);
  }

  clearToken(): void {
    localStorage.removeItem(LOCAL_STORAGE.TOKEN);
  }
}
