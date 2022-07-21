import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Project } from '../project';
import { ProjectServiceService } from '../services/project-service.service';
@Component({
  selector: 'app-projectlist',
  templateUrl: './projectlist.component.html',
  styleUrls: ['./projectlist.component.css']
})
export class ProjectlistComponent implements OnInit {


  projects:any;
  constructor(private _roter:Router,private projectService: ProjectServiceService) { }

  ngOnInit(): void {
    let resp =this.projectService.listProjectsFromRemote();
    resp.subscribe((data) => {
      console.log(data);
      this.projects=data;
    });
  }
  goToAddProject(){
    this._roter.navigate(['addproject'])
  }
  goToEdit(id:number){
    this._roter.navigate(['editproject',id])
  }

  goToViewOf(id:number){
      this._roter.navigate(['viewproject',id])
  }
  deleteProject(id:number){
    this.projectService.deleteProject(id).subscribe(
      (data) =>{
        console.log("Deleted successfuly");
       this.projects=this.projectService.listProjectsFromRemote();        
      
      },
    error=>console.log(error)
    ); 
  }
  goBack(){
    this._roter.navigate(['projectlist']);
  }

}
