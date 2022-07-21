import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Partner } from '../partner';
import { PartnerserviceService } from '../services/partnerservice.service';

@Component({
  selector: 'app-editpartner',
  templateUrl: './editpartner.component.html',
  styleUrls: ['./editpartner.component.css']
})
export class EditpartnerComponent implements OnInit {
  id!: number;
  partner: Partner= new Partner();
  constructor(private router: Router, private _partnerService:PartnerserviceService, private _activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this._activatedRoute.snapshot.params['id']
    let result = this._partnerService.partnerById(this.id);
    result.subscribe((data) =>this.partner=data,
    (error)=> console.log("Error"))
  }
  updatePartner() {
    this._partnerService.updatePartner(this.id, this.partner).subscribe(
      (data) =>this.goBack()
      
      )
  }
  goBack(){
    this.router.navigate(['partnerlist'])
  }
}
