import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

/**
 * Service for Category retrieveing and persisting in backend
 *
 * @author Mark Salumaa
 */

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private URL = '/api/category';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any>{
    return this.http.get(`${this.URL}/`);
  }

  get(id): Observable<any>{
    return this.http.get(`${this.URL}/${id}`);
  }

  create(customer): Observable<any>{
    return this.http.post(`${this.URL}/`, customer);
  }

  update(customer): Observable<any>{
    return this.http.put(`${this.URL}/`, customer);
  }

  delete(customer): Observable<any>{
    return this.http.post(`${this.URL}/delete`, customer);
  }

  restore(customer): Observable<any>{
    return this.http.post(`${this.URL}/restore`, customer);
  }

}
