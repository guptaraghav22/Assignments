import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UpdateproductService {

  constructor(private http:HttpClient) { }

baseurl:string="http://localhost:2222/updatereview";
deleteurl:string="http://localhost:2222/updatereviewdelete"
  updateproduct(id:any)
  {
    

   return this.http.put<any>(this.baseurl,id)
   .pipe(map((res:any)=>{
    return res;
   }))
  
}

decline(id:any)
{
  
  return this.http.put<any>(this.deleteurl,id)
  .pipe(map((res:any)=>{
   return res;
  }))
 
}
}
