import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';



/**
 * Service for Product retrieveing and persisting in backend
 *
 * @author Mark Salumaa
 */


@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private URL = '/api/product';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any>{
    return this.http.get(`${this.URL}/`);
  }

  getAllActive(): Observable<any>{
    return this.http.get(`${this.URL}/active`);
  }

  filterByComponentId(id): Observable<any>{
    return this.http.get(`${this.URL}/filter/${id}`);
  }

  get(id): Observable<any>{
    return this.http.get(`${this.URL}/${id}`);
  }

  create(product): Observable<any>{
    return this.http.post(`${this.URL}/`, product);
  }

  update(product): Observable<any>{
    return this.http.put(`${this.URL}/`, product);
  }

  delete(id): Observable<any>{
    return this.http.post(`${this.URL}/delete/${id}`, null);
  }

  restore(id): Observable<any>{
    return this.http.post(`${this.URL}/restore/${id}`, null);
  }


}
