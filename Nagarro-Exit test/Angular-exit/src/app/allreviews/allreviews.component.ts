import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { map } from 'rxjs';
import { ProductReview } from '../product-review';
import { ReviewserviceService } from '../reviewservice.service';
import { UsernameserviceService } from '../usernameservice.service';

@Component({
  selector: 'app-allreviews',
  templateUrl: './allreviews.component.html',
  styleUrls: ['./allreviews.component.css']
})
export class AllreviewsComponent implements OnInit {
  
  code:any
  constructor(private usernameservice:UsernameserviceService,
    private router :Router,private http:HttpClient,private reviewservice:ReviewserviceService) {
    
    
    
   }
   email:any
  ngOnInit(): void {
    this.getcode();
    this.getusername()
  }


  productcode:number=1;
  getreview(productcode:any)
  {

  //  return this.http.get<any>("http://localhost:2222/getreview")
  //  .pipe(map((res:any)=>{
  //    return res;
  //  }))

     
  
}
productlist:ProductReview []=[]

  
// getcode(){
//   this.code=this.reviewservice.getcode();
//   console.log(this.code)
//   this.http.get<any>("http://localhost:2222/getreview?productcode=" + this.code ).subscribe(res => {
  


//    for(let object of res)
//    {
//     if(object.approved==1)
//     {
//       console.log("hy")
//     }
//    }
//       this.productlist=res;
      
//       console.log(this.productlist)    
//       console.log(res)

//       })
// }

getcode(){
  this.code=this.reviewservice.getcode();
  console.log(this.code)
  this.http.get<any>("http://localhost:2222/getreview?productcode=" + this.code ).subscribe(res => {
  


   for(let object of res)
   {
    if(object.approved==1)
    {
      this.productlist.push(object);
      console.log(this.productlist)
    }
   }
      
      console.log(this.productlist)    

      })
}
back()
{
  this.router.navigate(["/product"]);
}

getusername()
{
  this.email=this.usernameservice.getusername();
  console.log(this.email);
}
}
