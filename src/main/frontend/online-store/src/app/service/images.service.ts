import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const URL = "http://localhost:8080/api/images"

@Injectable({
  providedIn: 'root'
})
export class ImagesService {

  constructor(private http: HttpClient) {
  }

  create(image): Observable<any>{
    return this.http.post(URL + "/", image);
  }

  getById(id): Observable<any>{
    return this.http.get(`${URL}/${id}`);
  }
}
