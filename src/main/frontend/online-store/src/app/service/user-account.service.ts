import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";



@Injectable({
  providedIn: 'root'
})
export class UserAccountService {
  private URL = '/api/user-account/'
  constructor(private http: HttpClient) { }

  getUserAccountById(id): Observable<any> {
    return this.http.get(`${this.URL}${id}`);
  }

  saveUserAccount(userAccount): Observable<any> {
    return this.http.post(this.URL, userAccount);
  }

  getAllUserAccounts(): Observable<any>{
    return this.http.get(this.URL);
  }

  updateUserAccount(userAccount): Observable<any> {
    return this.http.put(this.URL, userAccount);
  }

  deleteUserAccount(id): Observable<any> {
    return this.http.post(`${this.URL}delete/${id}`,null);
  }

  restoreUserAccount(id): Observable<any> {
    return this.http.post(`${this.URL}restore/${id}`,null);
  }
}
