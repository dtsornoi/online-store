import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

/**
 * Service for Address retrieving and persisting in Backend
 *
 * @author Vladimir
 */

@Injectable({
  providedIn: 'root'
})
export class AdressService {

  private URL = '/api/address';

  constructor(private http: HttpClient) { }

  getAllAddresses(): Observable<any>{
    return this.http.get(`${this.URL}/`);
  }

  getAddressById(id): Observable<any>{
    return this.http.get(`${this.URL}/${id}`);
  }

  addAddress(address): Observable<any>{
    return this.http.post(`${this.URL}/`, address);
  }

  updateAddress(address): Observable<any>{
    return this.http.put(`${this.URL}/`, address);
  }

  deleteAddress(address): Observable<any>{
    return this.http.post(`${this.URL}/delete/`, address);
  }

  restoreAddress(address): Observable<any>{
    return this.http.post(`${this.URL}/restore/`, address);
  }
}
