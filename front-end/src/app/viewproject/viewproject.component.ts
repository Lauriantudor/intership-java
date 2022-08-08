import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Project } from '../project';
import { ProjectServiceService } from '../services/project-service.service';

@Component({
  selector: 'app-viewproject',
  templateUrl: './viewproject.component.html',
  styleUrls: ['./viewproject.component.css']
})
export class ViewprojectComponent implements OnInit {

  id!: number
  project=  new Project();
  constructor(private _rote: Router, private _projectService: ProjectServiceService, private _activatedRoute : ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this._activatedRoute.snapshot.params['id'];
    this._projectService.projectById(this.id).subscribe(
      data => this.project=data,
      error => console.log("err")
    )

  }
  goToAddPartner(id:any){
    this._rote.navigate(['addpartnerto',id])
  }
  goBack(){
    this._rote.navigate(['projectlist']);
  }

}

