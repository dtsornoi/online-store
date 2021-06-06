import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';



/**
 * Service for OrderLine retrieveing and persisting in backend
 *
 * @author Mark Salumaa
 */

@Injectable({
  providedIn: 'root'
})
export class OrderLineService {

  private URL = '/api/order-line';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any>{
    return this.http.get(`${this.URL}/`);
  }

  get(id): Observable<any>{
    return this.http.get(`${this.URL}/${id}`);
  }

  create(orderLine): Observable<any>{
    return this.http.post(`${this.URL}/`, orderLine);
  }

  update(orderLine): Observable<any>{
    return this.http.put(`${this.URL}/`, orderLine);
  }

  delete(id): Observable<any>{
    return this.http.post(`${this.URL}/delete/${id}`, null);
  }

  restore(orderLine): Observable<any>{
    return this.http.post(`${this.URL}/restore`, orderLine);
  }

  quantityPlus(id): Observable<any>{
    return this.http.post(`${this.URL}/plus/${id}`,null);
  }

  quantityMinus(id): Observable<any>{
    return this.http.post(`${this.URL}/minus/${id}`,null);
  }

  getActiveUserId(id): Observable<any>{
    return this.http.get(`${this.URL}/user/${id}`);
  }

}
