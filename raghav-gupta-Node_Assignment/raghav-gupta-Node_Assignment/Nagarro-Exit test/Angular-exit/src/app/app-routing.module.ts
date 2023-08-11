import {  NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RegisterComponent} from './register/register.component'
import {LoginComponent} from './login/login.component'
import { LoginsuccessComponent } from './loginsuccess/loginsuccess.component';
import { AuthGuard } from './auth.guard';
import { ProductdisplayComponent } from './productdisplay/productdisplay.component';
import { AddreviewComponent } from './addreview/addreview.component';
import { AllreviewsComponent } from './allreviews/allreviews.component';
import { HomePageComponent } from './home-page/home-page.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { AdminhomepageComponent } from './adminhomepage/adminhomepage.component';
const routes: Routes = 
[ {path:"register",component:RegisterComponent},
  {path:"login",component:LoginComponent},
  {path:"loginsuccess",component:LoginsuccessComponent,canActivate:[AuthGuard]},
  {path:"product",component:ProductdisplayComponent,canActivate:[AuthGuard]},
  {path:"addreview",component:AddreviewComponent,canActivate:[AuthGuard]},
  {path:"allreview",component:AllreviewsComponent,canActivate:[AuthGuard]},
  {path:"homepage",component:HomePageComponent},
  {path:"admin",component:AdminhomeComponent},
  {path:"adminhomepage",component:AdminhomepageComponent},


  {path:'',redirectTo:'homepage',pathMatch:'full'},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
