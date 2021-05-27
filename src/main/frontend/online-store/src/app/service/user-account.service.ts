import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

const URL = 'http://localhost:8080/api/user-account/'

@Injectable({
  providedIn: 'root'
})
export class UserAccountService {

  constructor(private http: HttpClient) { }

  getUserAccountById(id): Observable<any> {
    return this.http.get(`${URL}${id}`);
  }

  saveUserAccount(userAccount): Observable<any> {
    return this.http.post(URL, userAccount);
  }

  getAllUserAccounts(): Observable<any>{
    return this.http.get(URL);
  }

  updateUserAccount(userAccount): Observable<any> {
    return this.http.put(URL, userAccount);
  }

  deleteUserAccount(id): Observable<any> {
    return this.http.post(`${URL}delete/${id}`,null);
  }

  restoreUserAccount(id): Observable<any> {
    return this.http.post(`${URL}restore/${id}`,null);
  }
}
