import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const URL = 'http://localhost:8080/api/order-line'

/**
 * Service for OrderLine retrieveing and persisting in backend
 * 
 * @author Mark Salumaa
 */

@Injectable({
  providedIn: 'root'
})
export class OrderLineService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any>{
    return this.http.get(`${URL}/`);
  }

  get(id): Observable<any>{
    return this.http.get(`${URL}/${id}`);
  }

  create(orderLine): Observable<any>{
    return this.http.post(`${URL}/`, orderLine);
  }

  update(orderLine): Observable<any>{
    return this.http.put(`${URL}/`, orderLine);
  }

  delete(orderLine): Observable<any>{
    return this.http.post(`${URL}/delete`, orderLine);
  }

  restore(orderLine): Observable<any>{
    return this.http.post(`${URL}/restore`, orderLine);
  }

  quantityPlus(id): Observable<any>{
    return this.http.post(`${URL}/plus/${id}`,null);
  }

  quantityMinus(id): Observable<any>{
    return this.http.post(`${URL}/minus/${id}`,null);
  }

}
