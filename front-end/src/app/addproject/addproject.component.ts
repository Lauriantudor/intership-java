import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Project } from '../project';
import { ProjectServiceService } from '../services/project-service.service';
@Component({
  selector: 'app-addproject',
  templateUrl: './addproject.component.html',
  styleUrls: ['./addproject.component.css']
})
export class AddprojectComponent implements OnInit {

  project: Project= new Project();
  constructor(private _rote:Router, private _projectService:ProjectServiceService) { }

  ngOnInit(): void {
  }
  addProject(){
    this._projectService.addProject(this.project).subscribe(
      data => {
        console.log("Project adeded");
        this._rote.navigate(['projectlist']);
      }
      )
  }
  goBack(){
    this._rote.navigate(['projectlist']);
  }
}