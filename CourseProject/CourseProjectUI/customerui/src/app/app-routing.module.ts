import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddComponent } from './add/add.component';
import { BynameComponent } from './byname/byname.component';
import { BynumberComponent } from './bynumber/bynumber.component';
import { DetailsComponent } from './details/details.component';
import { HomeComponent } from './home/home.component';
import { NotfoundComponent } from './notfound/notfound.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'customers/:id', component: DetailsComponent},
  {path: 'add', component: AddComponent},
  {path: 'bynumber/:phoneNumber', component: BynumberComponent},
  {path: 'byname/:lastName', component: BynameComponent},
  {path: '**', component: NotfoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
