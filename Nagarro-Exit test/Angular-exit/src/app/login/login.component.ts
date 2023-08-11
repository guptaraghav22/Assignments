import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { LoginserviceService } from '../loginservice.service';
import { RegistrationService } from '../registration.service';
import { User } from '../user';
import { UsernameserviceService } from '../usernameservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  user = new User();
  constructor(private _service: RegistrationService, private _router: Router, 
    private loginservice: LoginserviceService,private usernameservice:UsernameserviceService) { }

  ngOnInit(): void {
  }
  msg = "";

  // loginUser() {
  //   this._service.loginUserfromRemote(this.user).subscribe(
  //     (data: any) => {
  //       console.log("response recived")
        
  //       this._router.navigate(["/loginsuccess"]);
  //     }
  //     , error => {
  //       console.log("exception occoured")
  //       this.msg = "please enter correct credentials";
  //     }
  //   )
  // }

errmsg=""
  login() {
    this.usernameservice.postemailid(this.user.emailid);
    console.log(this.user.emailid)
        
    this.loginservice.generateToken(this.user).subscribe(
      (response: any) => {

        
        this.loginservice.loginUser(response.token);
        //window.location.href = "/product"
        this._router.navigateByUrl("/product");
      },
      error => {
        this.errmsg="No User Found Please Enter Correct Credentials"
      }
    )
  }

}
