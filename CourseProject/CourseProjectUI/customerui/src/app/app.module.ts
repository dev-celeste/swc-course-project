import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { DetailsComponent } from './details/details.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { AddComponent } from './add/add.component';
import { BynumberComponent } from './bynumber/bynumber.component';
import { BynameComponent } from './byname/byname.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    DetailsComponent,
    NotfoundComponent,
    AddComponent,
    BynumberComponent,
    BynameComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
