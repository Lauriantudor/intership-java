import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PartnerserviceService } from '../services/partnerservice.service';

@Component({
  selector: 'app-partnerlist',
  templateUrl: './partnerlist.component.html',
  styleUrls: ['./partnerlist.component.css']
})
export class PartnerlistComponent implements OnInit {


  partners:any;

  constructor(private router:Router, private patnerService:PartnerserviceService) { }

  ngOnInit(): void {
    let resp = this.patnerService.listPartnersFromRemote();
    resp.subscribe((data)=>{
      console.log(data);
      this.partners = data;
    });
  }
  goToAddPartner(){
      this.router.navigate(['addpartner']);
  }
  goToEdit(id:number){
    this.router.navigate(['editpartner',id])
  }
  goToViewOf(id:number){
    this.router.navigate(['viewpartner',id])
  }
  deletePartner(partner:any){
    this.patnerService.deletePartner(partner.id).subscribe(
      data =>{
        console.log("Deleted successfuly");
        this.partners=this.patnerService.listPartnersFromRemote();
      }, 
      error => console.log(error)
    )
  }


}
