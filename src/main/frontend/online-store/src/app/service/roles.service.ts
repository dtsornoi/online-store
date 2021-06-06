import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";



/**
 * Service for Role retrieving and persisting in Backend
 *
 * @author Dmitri Tsornoi
 */
@Injectable({
  providedIn: 'root'
})
export class RolesService {
  private URL = '/api/role';

  constructor(private http: HttpClient) {}


  getAllRoles(): Observable<any> {
    return this.http.get(`${this.URL}/`);
  }

  getRoleById(id): Observable<any>{
    return this.http.get(`${this.URL}/${id}`);
  }

  addRole(role): Observable<any>{
    return this.http.post(`${this.URL}/`, role);
  }

  updateRole(role): Observable<any>{
    return this.http.put(`${this.URL}/`, role);
  }

  deleteRole(role): Observable<any> {
    return this.http.post(`${this.URL}/delete/`, role);
  }

  restore(role): Observable<any> {
    return this.http.post(`${this.URL}/restore/`, role);
  }
}

