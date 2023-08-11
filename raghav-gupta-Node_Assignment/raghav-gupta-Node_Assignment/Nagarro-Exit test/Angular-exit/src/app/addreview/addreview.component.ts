import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {ProductReview} from '../product-review'
import { RegisterReviewService } from '../register-review.service';
import { RegistrationService } from '../registration.service';
import { ReviewserviceService } from '../reviewservice.service';
import { UsernameserviceService } from '../usernameservice.service';
@Component({
  selector: 'app-addreview',
  templateUrl: './addreview.component.html',
  styleUrls: ['./addreview.component.css']
})
export class AddreviewComponent implements OnInit {

  constructor(private usernameservice:UsernameserviceService,private _service:RegisterReviewService,
    private reviewservice:ReviewserviceService,
    private router:Router) { }
  productReview = new ProductReview
  ngOnInit(): void {
    this.getcode();
    this.getusername();
  }
  email:any;
msg="";
code:any;
  registerreview(){
    this.productReview.productcode=this.code;
    


    this.productReview.emailid=this.email;
    
    if(this.productReview.productcode!=null 
      && this.productReview.productrating!=null && this.productReview.productreview!=null && this.productReview.productreview!="" ){
    this._service.RegisterReview(this.productReview).subscribe(
      data=>{
        window.alert("Registered successfull");
      }
      ,error=>{
        console.log("exception occoured")
        this.msg="not registered";
      }
      )
    }
    else{
      this.msg="not registered"
    }
  }

  getcode()
  {
    this.code=this.reviewservice.getcode();
    this.code=localStorage.getItem('alternativecode')
     
  }
  back()
  {
    this.router.navigate(["/product"]);
  }
  getusername()
  {
    this.email=this.usernameservice.getusername();
    this.email=localStorage.getItem('emailidd');
  }
}
