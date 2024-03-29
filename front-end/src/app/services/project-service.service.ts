import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Project } from '../project';
import { Partner } from '../partner';
@Injectable({
  providedIn: 'root'
})
export class ProjectServiceService {

  constructor( private _http: HttpClient) { }

  listProjectsFromRemote(): Observable<any> {
    return this._http.get("http://localhost:8080/rest/project")
  }
  addProject(project:Project):Observable<any> {
    return this._http.post<any>("http://localhost:8080/rest/project", project)
  }
  partnerOf(id:number): Observable<any> {
    return this._http.get<any>("http://localhost:8080/rest/partner/getpartnersOf/"+id)
  }
  projectById(id:number): Observable<any> {
    return this._http.get("http://localhost:8080/rest/project/"+id)
  }
  updateProject(id:number, project:Project):Observable<any> {
    return this._http.put("http://localhost:8080/rest/project/"+id, project)
  }
  deleteProject(id:number): Observable<any> {
    return this._http.delete("http://localhost:8080/rest/project/"+id)
  }
  addPartnerto(idproj:number, partner:Partner): Observable<any> {
    return this._http.post<any>("http://localhost:8080/rest/project/addto/"+idproj, partner)
  }
  
}
