import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

/**
 * Service for Orders retrieveing and presisting in backend
 *
 * @author Mark Salumaa
 */


@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  private URL = '/api/orders';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any>{
    return this.http.get(`${this.URL}/`);
  }

  get(id): Observable<any>{
    return this.http.get(`${this.URL}/${id}`);
  }

  getbyUserId(id): Observable<any>{
    return this.http.get(`${this.URL}/user/${id}`);
  }

  create(order): Observable<any>{
    return this.http.post(`${this.URL}/`, order);
  }

  update(order): Observable<any>{
    return this.http.put(`${this.URL}/`, order);
  }

  delete(order): Observable<any>{
    return this.http.post(`${this.URL}/delete`, order);
  }

  restore(order): Observable<any>{
    return this.http.post(`${this.URL}/restore`, order);
  }

}
