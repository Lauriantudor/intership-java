import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PartnerserviceService } from '../services/partnerservice.service';
import { ProjectServiceService } from '../services/project-service.service';

@Component({
  selector: 'app-addpartnertoproj',
  templateUrl: './addpartnertoproj.component.html',
  styleUrls: ['./addpartnertoproj.component.css']
})
export class AddpartnertoprojComponent implements OnInit {

  partners:any;
  id!:number;
  constructor(private projectService:ProjectServiceService,
    private partnerService:PartnerserviceService,
    private _activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    let resp = this.partnerService.listPartnersFromRemote();
    resp.subscribe((data)=>{
      console.log(data);
      this.partners = data;
    });
  }

  addPartnerto(idpartner:number){
     this.id = this._activatedRoute.snapshot.params['id'];
    this.projectService.addPartnerto(this.id,idpartner).subscribe(
      data =>{
        console.log("workt");
      },
      error => console.log("error")
    );
    console.log("idproj"+ this.id+"                       id:"+idpartner)

  }

}
