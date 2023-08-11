import { ComponentFactoryResolver, Injectable } from '@angular/core';
import { User } from './user';
import {Observable} from 'rxjs'
import {HttpClient,HttpClientModule} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private _http:HttpClient) { }

public loginUserfromRemote(user:User):Observable<any>
{
  console.log(user);
  
  return this._http.post<any>("http://localhost:2222/login",user)

}
public RegisterUserfromRemote(user:User):Observable<any>
{
  console.log(user.emailid)
  return this._http.post<any>("http://localhost:2222/register",user)
}


}
