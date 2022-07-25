import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Partner } from '../partner';

@Injectable({
  providedIn: 'root'
})
export class PartnerserviceService {

  constructor( private _http: HttpClient) { }
  listPartnersFromRemote(): Observable<any> {
    return this._http.get("http://localhost:8080/rest/partner")
  }
  addPartner(partner:Partner):Observable<any> {
    return this._http.post<any>("http://localhost:8080/rest/partner", partner)
  }
  partnerById(id:number):Observable<any> {
    return this._http.get<any>("http://localhost:8080/rest/partner/"+id)
  }
  updatePartner(id:number, partner:Partner):Observable<any> {
    return this._http.put("http://localhost:8080/rest/partner/"+id, partner)
  }
  deletePartner(id:number): Observable<any> {
    return this._http.delete("http://localhost:8080/rest/partner/"+id)
  }
}
