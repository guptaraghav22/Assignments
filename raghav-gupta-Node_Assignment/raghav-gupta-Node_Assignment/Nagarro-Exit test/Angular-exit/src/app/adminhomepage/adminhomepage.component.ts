import { HttpBackend, JsonpClientBackend } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminproductService } from '../adminproduct.service';
import { ProductReview } from '../product-review';
import { UpdateproductService } from '../updateproduct.service';

@Component({
  selector: 'app-adminhomepage',
  templateUrl: './adminhomepage.component.html',
  styleUrls: ['./adminhomepage.component.css']
})
export class AdminhomepageComponent implements OnInit {

  constructor(private router:Router,private api:AdminproductService,private updateservice:UpdateproductService) { }
  productlist:ProductReview []=[]

  productlistt:any
  productReview:any;
  ngOnInit(): void {
    this.getallproducts()
  }

  getallproducts()
  {
        
    this.api.getproduct().subscribe(res=>{
      this.productlistt=res;
      for(let object of res)
      {
       if(object.approved==null)
       {
         this.productlist.push(object);
         
       }
      }
        
 
      
    })

  }

decline(id:any)
{
  
  console.log("decline")

  
  this.updateservice.decline(id).subscribe(res=>{
    console.log("decline service");
});
//this.router.navigate(["/adminhomepage"])  
   window.location.href = "/adminhomepage"
}
approve(id:any)
{
  this.updateservice.updateproduct(id).subscribe(res=>{
      console.log("Approved");
    
    });

  //this.router.navigate(["/adminhomepage"])  
  window.location.href = "/adminhomepage"
}

back()
{
  this.router.navigate(["/homepage"])
}
}