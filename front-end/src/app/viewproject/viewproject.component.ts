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
  partner: any
  constructor(private _rote: Router, private _projectService: ProjectServiceService, private _activatedRoute : ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this._activatedRoute.snapshot.params['id'];
    this._projectService.projectById(this.id).subscribe(
      data => this.project=data,
      error => console.log("err")
      
    )
      this._projectService.partnerOf(this.id).subscribe(
        data =>{
          console.log(data);
          this.partner=data
      },
        error=> console.log(error)
      )
  }
  goToAddPartner(id:any){
    this._rote.navigate(['addpartnerto',id])
  }
  goToViewOf(id:number){
    this._rote.navigate(['viewpartner',id])
  }
  goBack(){
    this._rote.navigate(['projectlist']);
  }

}

