import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProjectlistComponent } from './projectlist/projectlist.component';
import { EditprojectComponent } from './editproject/editproject.component';
import { AddprojectComponent } from './addproject/addproject.component';
import { ViewprojectComponent } from './viewproject/viewproject.component';
import { HomeComponent } from './home/home.component';
import { PartnerlistComponent } from './partnerlist/partnerlist.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AddpartnerComponent } from './addpartner/addpartner.component';
import { ViewpartnerComponent } from './viewpartner/viewpartner.component';
import { EditpartnerComponent } from './editpartner/editpartner.component';
import { AddpartnertoprojComponent } from './addpartnertoproj/addpartnertoproj.component';

@NgModule({
  declarations: [
    AppComponent,
    ProjectlistComponent,
    EditprojectComponent,
    AddprojectComponent,
    ViewprojectComponent,
    HomeComponent,
    PartnerlistComponent,
    AddpartnerComponent,
    ViewpartnerComponent,
    EditpartnerComponent,
    AddpartnertoprojComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
