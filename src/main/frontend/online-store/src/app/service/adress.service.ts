import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

const URL = 'http://localhost:8080/api/address'

/**
 * Service for Address retrieving and persisting in Backend
 *
 * @author Vladimir
 */

@Injectable({
  providedIn: 'root'
})
export class AdressService {

  constructor(private http: HttpClient) { }

  getAllAddresses(): Observable<any>{
    return this.http.get(`${URL}`);
  }

  getAddressById(id): Observable<any>{
    return this.http.get(`${URL}/${id}`);
  }

  addAddress(address): Observable<any>{
    return this.http.post(`${URL}/`, address);
  }

  updateAddress(address): Observable<any>{
    return this.http.put(`${URL}/`, address);
  }

  deleteAddress(address): Observable<any>{
    return this.http.post(`${URL}/delete/`, address);
  }

  restoreAddress(address): Observable<any>{
    return this.http.post(`${URL}/restore/`, address);
  }
}
