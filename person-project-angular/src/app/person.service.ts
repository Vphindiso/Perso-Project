import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  savePersonDetails(person: Object): Observable<Object>{
    return this.http.post(`${this.baseUrl + "/person"}`, person);
  }

  getAllPeople(): Observable<any>{
    return this.http.get(`${this.baseUrl +"/people"}`);
  }

}
