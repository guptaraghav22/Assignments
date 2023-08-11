import { Component, OnInit } from '@angular/core';
import {AdminLogin} from '../admin/admin-login'
@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent implements OnInit {

  credentials={
    username:'',
    password:''
  }

  constructor() { }
  adminLogin = new AdminLogin()
  ngOnInit(): void {
  }

  login()
  {
        if(this.credentials.username=="admin" && this.credentials.password=="admin")
    {
    window.location.href = "/adminhomepage"
    }
    else{
      console.log("user not found")
    }
  
  }

}
