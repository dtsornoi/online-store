import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {UserAccount} from '../model/user-account.module';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private AUTH_API = 'http://localhost:8080/api/auth/';

  constructor(private http: HttpClient) { }
  login(credentials): Observable<any> {
    return this.http.post(this.AUTH_API + 'signin', {
      login: credentials.login,
      password: credentials.password
    }, httpOptions);
  }

  register(user: UserAccount): Observable<any> {
    return this.http.post(this.AUTH_API + 'signup', {
      login: user.login,
      password: user.password,
      address: user.address,
      isActive: user.isActive,
      firstName: user.firstName,
      lastName: user.lastName,
      roles: user.roles
    }, httpOptions);
  }

}
