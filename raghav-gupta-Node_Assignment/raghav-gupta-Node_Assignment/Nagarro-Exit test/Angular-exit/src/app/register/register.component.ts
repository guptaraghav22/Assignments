import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { User } from '../user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  msg="";
  constructor(private _service:RegistrationService,private _router:Router) { }
  user = new User();
  ngOnInit(): void {
  }
  // registeruser(){

  //   this._service.RegisterUserfromRemote(this.user).subscribe(
     
  //     data=>{
  //       console.log("response recived")
  //       this.msg="register success";
  //     }
  //     ,error=>{
  //       console.log("exception occoured")
  //       this.msg="please enter correct credentials";
  //     }
  //     )

  // }
  registeruser(){

    if(this.user.emailid!=null && this.user.firstname!=null && this.user.lastname!=null
      && this.user.password!=null && this.user.confirmpassword!=null && this.user.confirmpassword==this.user.password
      ){
    this._service.RegisterUserfromRemote(this.user).subscribe(
        
        data=>{
        console.log("response recived")
        this.msg="register success";
      }
      ,error=>{
        console.log("exception occoured")
        this.msg="please enter correct credentials";
      }
      )
    }
    else
    {
      this.msg="enter required details correctly"
    }
  }
}
