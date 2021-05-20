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

  create(customer): Observable<any>{
    return this.http.post(`${URL}/`, customer);
  }

  update(customer): Observable<any>{
    return this.http.put(`${URL}/`, customer);
  }

  delete(customer): Observable<any>{
    return this.http.post(`${URL}/delete`, customer);
  }

  restore(customer): Observable<any>{
    return this.http.post(`${URL}/restore`, customer);
  }

}
