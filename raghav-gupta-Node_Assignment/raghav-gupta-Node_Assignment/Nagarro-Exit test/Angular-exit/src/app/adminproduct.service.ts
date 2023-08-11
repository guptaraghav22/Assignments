import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminproductService {
  public productlist:any
 baseurl:string="http://localhost:2222/adminproducts"
  constructor(private http:HttpClient) { }
  getproduct()
  {
   return this.http.get<any>(this.baseurl)
   .pipe(map((res:any)=>{
     this.productlist=res;
     return res;
   }))
  }
}
