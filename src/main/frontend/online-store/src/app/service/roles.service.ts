import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

const URL = 'http://localhost:8080/api/role'

/**
 * Service for Role retrieving and persisting in Backend
 *
 * @author Dmitri Tsornoi
 */
@Injectable({
  providedIn: 'root'
})
export class RolesService {

  constructor(private http: HttpClient) {}


  getAllRoles(): Observable<any> {
    return this.http.get(`${URL}/`);
  }

  getRoleById(id): Observable<any>{
    return this.http.get(`${URL}/${id}`);
  }

  addRole(role): Observable<any>{
    return this.http.post(`${URL}/`, role);
  }

  updateRole(role): Observable<any>{
    return this.http.put(`${URL}/`, role);
  }

  deleteRole(role): Observable<any> {
    return this.http.post(`${URL}/delete/`, role);
  }

  restore(role): Observable<any> {
    return this.http.post(`${URL}/restore/`, role);
  }
}

