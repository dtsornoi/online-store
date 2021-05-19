import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../model/customer.module';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private customerServiceUrl = 'http://localhost:8080/api/customer/';
  private deleteCustomerServiceUrl = 'http://localhost:8080/api/customer/delete/';
  private restoreCustomerServiceURL = 'http://localhost:8080/api/customer/restore/';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.customerServiceUrl);
  }

  get(id: number): Observable<Customer>{
    return this.http.get(`${this.customerServiceUrl}/${id}`)
  }

  create(data: Customer): Observable<Customer>{
    return this.http.post(this.customerServiceUrl, data);
  }

  update(data: Customer): Observable<Customer>{
    return this.http.put(this.customerServiceUrl, data);
  }

  delete(id: number, data: Customer): Observable<Customer>{
    return this.http.post(`${this.deleteCustomerServiceUrl}/${id}`, data);
  }

  restore(id: number, data: Customer): Observable<Customer>{
    return this.http.post(`${this.restoreCustomerServiceURL}/${id}`, data);
  }

}
