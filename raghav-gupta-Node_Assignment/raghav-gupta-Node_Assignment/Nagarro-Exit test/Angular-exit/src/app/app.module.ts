import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoginsuccessComponent } from './loginsuccess/loginsuccess.component';
import { ProductdisplayComponent } from './productdisplay/productdisplay.component';
import { FilterPipe } from './shared/filter.pipe';
import { AddreviewComponent } from './addreview/addreview.component';
import { AllreviewsComponent } from './allreviews/allreviews.component';
import { HomePageComponent } from './home-page/home-page.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { AdminhomepageComponent } from './adminhomepage/adminhomepage.component';
import { AuthGuard } from './auth.guard';
import { LoginserviceService } from './loginservice.service';
import { AuthInterceptor } from './auth.interceptor';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    LoginsuccessComponent,
    ProductdisplayComponent,
    FilterPipe,
    AddreviewComponent,
    AllreviewsComponent,
    HomePageComponent,
    AdminhomeComponent,
    AdminhomepageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [LoginserviceService,AuthGuard,[{provide:HTTP_INTERCEPTORS,useClass:AuthInterceptor,multi:true}]],
  bootstrap: [AppComponent]
})
export class AppModule { }
