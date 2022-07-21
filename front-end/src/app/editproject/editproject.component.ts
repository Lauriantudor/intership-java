import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Project } from '../project';
import { ProjectServiceService } from '../services/project-service.service';

@Component({
  selector: 'app-editproject',
  templateUrl: './editproject.component.html',
  styleUrls: ['./editproject.component.css']
})
export class EditprojectComponent implements OnInit {

  project: Project= new Project();
  id!: number;
  constructor(private _rote: Router, private _projectService: ProjectServiceService, private _activatedRoute: ActivatedRoute ) { }

  ngOnInit(): void {
   this.id =this._activatedRoute.snapshot.params['id'];
    let result = this._projectService.projectById(this.id)
    result.subscribe(
      (data) => {
        console.log(data);
        this.project = data
      },
      (error) => console.log("Error")
    );
    }
  updateProject(){
    this._projectService.updateProject(this.id, this.project).subscribe(
      (data) => {
        console.log(data);
        this.goBack();
      }
      )
  }
  goBack(){
    this._rote.navigate(['projectlist']);
  }
}
