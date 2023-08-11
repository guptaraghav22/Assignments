import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UsernameserviceService {

  constructor() { }

  emailid:any

  postemailid(email:any)
  {
    console.log("posted"+email);
    this.emailid=email;
    console.log("posted"+this.emailid);
    localStorage.setItem("emailidd",this.emailid); 
  }
  getusername()
  {
    console.log("got"+this.emailid)
   
    return this.emailid;

  }
}
