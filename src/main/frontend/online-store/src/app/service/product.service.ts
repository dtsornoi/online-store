import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const URL = 'http://localhost:8080/api/product'

/**
 * Service for Product retrieveing and persisting in backend
 *
 * @author Mark Salumaa
 */


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any>{
    return this.http.get(`${URL}/`);
  }

  getAllActive(): Observable<any>{
    return this.http.get(`${URL}/active`);
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

  delete(id): Observable<any>{
    return this.http.post(`${URL}/delete/${id}`, null);
  }

  restore(id): Observable<any>{
    return this.http.post(`${URL}/restore/${id}`, null);
  }


}
