import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class ImagesService {

  private URL = "/api/images";

  constructor(private http: HttpClient) {
  }

  create(image): Observable<any>{
    return this.http.post(this.URL + "/", image);
  }

  getById(id): Observable<any>{
    return this.http.get(`${this.URL}/${id}`);
  }
}
