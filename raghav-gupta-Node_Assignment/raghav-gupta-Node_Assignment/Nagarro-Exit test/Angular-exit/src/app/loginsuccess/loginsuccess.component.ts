import { Component, OnInit } from '@angular/core';
import { UsernameserviceService } from '../usernameservice.service';

@Component({
  selector: 'app-loginsuccess',
  templateUrl: './loginsuccess.component.html',
  styleUrls: ['./loginsuccess.component.css']
})
export class LoginsuccessComponent implements OnInit {

  constructor(private usernameservice:UsernameserviceService) { }
  username:any
  ngOnInit(): void {
    
  }

}
