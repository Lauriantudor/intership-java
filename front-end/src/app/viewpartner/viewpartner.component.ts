import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Partner } from '../partner';
import { PartnerserviceService } from '../services/partnerservice.service';

@Component({
  selector: 'app-viewpartner',
  templateUrl: './viewpartner.component.html',
  styleUrls: ['./viewpartner.component.css']
})
export class ViewpartnerComponent implements OnInit {

  id!: number
  partner = new Partner();
  constructor(private router:Router, private _partnerService:PartnerserviceService, private _activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.id= this._activatedRoute.snapshot.params['id']
    this._partnerService.partnerById(this.id).subscribe(
      data=> this.partner=data,
      error=> console.log("error")
    )
  }
  goBack(){
    this.router.navigate(['partnerlist'])
  }
  goToProject(id:any){
  if(id != 0){
    console.log(id);
    this.router.navigate(['viewproject',id])
  }else{
    alert("No Project for this partner");
  }
  }

}
