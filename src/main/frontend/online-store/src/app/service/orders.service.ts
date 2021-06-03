import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const URL = 'http://localhost:8080/api/orders'

/**
 * Service for Orders retrieveing and presisting in backend
 * 
 * @author Mark Salumaa
 */


@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any>{
    return this.http.get(`${URL}/`);
  }

  get(id): Observable<any>{
    return this.http.get(`${URL}/${id}`);
  }

  create(order): Observable<any>{
    return this.http.post(`${URL}/`, order);
  }

  update(order): Observable<any>{
    return this.http.put(`${URL}/`, order);
  }

  delete(order): Observable<any>{
    return this.http.post(`${URL}/delete`, order);
  }

  restore(order): Observable<any>{
    return this.http.post(`${URL}/restore`, order);
  }

}
