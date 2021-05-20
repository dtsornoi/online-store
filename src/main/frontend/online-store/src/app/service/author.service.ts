import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

const URL = 'http://localhost:8080/api/author'

/**
 * Service for Author retrieving and persisting in Backend
 *
 * @author Vladimir
 */

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  constructor(private http: HttpClient) { }

  getAllAuthors(): Observable<any>{
    return this.http.get(`${URL}/`);
  }

  getAuthorById(id): Observable<any>{
    return this.http.get(`${URL}/${id}`);
  }

  addAuthor(author): Observable<any>{
    return this.http.post(`${URL}/`, author);
  }

  updateAuthor(author): Observable<any>{
    return this.http.put(`${URL}/`, author);
  }

  deleteAuthor(author): Observable<any>{
    return this.http.post(`${URL}/delete/`, author);
  }

  restoreAuthor(author): Observable<any>{
    return this.http.post(`${URL}/restore/`, author);
  }
}
