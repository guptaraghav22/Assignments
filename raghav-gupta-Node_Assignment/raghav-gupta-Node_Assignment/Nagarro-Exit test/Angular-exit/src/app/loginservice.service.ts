import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {
  url="http://localhost:2222/login";
  constructor(private http:HttpClient) { }

  loginUser(tkn:any)
  {
    let token=tkn;
    localStorage.setItem("token",token);
      return true;
  }


  isLoggedin()
  {
    let token=localStorage.getItem("token");
    if(token==undefined || token ==='' ||token==null)
    {
      return false;
    }
    else
    {
      return true;
    }
  }

  generateToken(user:any)
  {
    return this.http.post(this.url,user);
  }

      logout()
        {
          localStorage.removeItem("token");
        }

        getToken()
        {
          return localStorage.getItem("token");
        }

      }
