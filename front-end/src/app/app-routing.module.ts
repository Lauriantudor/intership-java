import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddpartnerComponent } from './addpartner/addpartner.component';
import { AddpartnertoprojComponent } from './addpartnertoproj/addpartnertoproj.component';
import { AddprojectComponent } from './addproject/addproject.component';
import { EditpartnerComponent } from './editpartner/editpartner.component';
import { EditprojectComponent } from './editproject/editproject.component';
import { HomeComponent } from './home/home.component';
import { PartnerlistComponent } from './partnerlist/partnerlist.component';
import { ProjectlistComponent } from './projectlist/projectlist.component';
import { ViewpartnerComponent } from './viewpartner/viewpartner.component';
import { ViewprojectComponent } from './viewproject/viewproject.component';

const routes: Routes = [
  {path:'', component:HomeComponent},


  {path:'addproject', component:AddprojectComponent},
  {path:'editproject/:id', component:EditprojectComponent},
  {path:'projectlist', component:ProjectlistComponent},
  {path: 'viewproject/:id', component:ViewprojectComponent},



  {path: 'partnerlist', component:PartnerlistComponent},
  {path: 'addpartner', component:AddpartnerComponent},

  {path:'addpartnerto/:id', component:AddpartnertoprojComponent},
  {path: 'viewpartner/:id', component:ViewpartnerComponent},
  {path: 'editpartner/:id', component:EditpartnerComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
