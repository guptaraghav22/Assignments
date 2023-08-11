import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ReviewserviceService {

  constructor(private http:HttpClient) { 
    
  }

  
code:any;

postcode(code:any)
{
  this.code=code;
}

getcode()
{
  return this.code;
}
        

}
