import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {map,} from 'rxjs/operators' 
import { BehaviorSubject, Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ProductserviceService {

  public searchstr = new BehaviorSubject<string>("");
  public searchbrandstr = new BehaviorSubject<string>("");
  public searchbrandcode = new BehaviorSubject<number>(0);
  
  public productlist:any;
  
  constructor(private http:HttpClient) 
  {
    
   }

   getproduct()
   {
    return this.http.get<any>("http://localhost:2222/product")
    .pipe(map((res:any)=>{
      this.productlist=res;
      return res;
    }))
   }

   getallproduct(AuthToken:any):Observable<any>{

    AuthToken=sessionStorage.getItem("token");
    const headers=new HttpHeaders().set("Authorization",AuthToken);
    return this.http.get("http://localhost:2222/product",{headers});

   }
}
