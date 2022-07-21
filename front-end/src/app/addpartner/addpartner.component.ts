import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Partner } from '../partner';
import { PartnerserviceService } from '../services/partnerservice.service';

@Component({
  selector: 'app-addpartner',
  templateUrl: './addpartner.component.html',
  styleUrls: ['./addpartner.component.css']
})
export class AddpartnerComponent implements OnInit {
  partner:Partner = new Partner();
  
  constructor(private _router:Router, private _partnerService:PartnerserviceService) { }

  ngOnInit(): void {
  }
  addPartner(){
    this._partnerService.addPartner(this.partner).subscribe(
      data => {
        console.log("Partner added");
        this.goBack();
      }
    )
  }
  goBack(){
    this._router.navigate(['partnerlist'])
  }

}
