import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { ProductserviceService } from '../productservice.service';
import { ReviewserviceService } from '../reviewservice.service';
import { UsernameserviceService } from '../usernameservice.service';

@Component({
  selector: 'app-productdisplay',
  templateUrl: './productdisplay.component.html',
  styleUrls: ['./productdisplay.component.css']
})
export class ProductdisplayComponent implements OnInit {

  searchname:string="";
  searchbrand:string="";
  searchcode:number=0;

  
  public searchTerm !:string;
  public searchBrand !:string;
  public searchCode !:string;
  
  alternativeemail:string  | null;
  
  msgstrr="";
  public check:boolean=false;
  public productlist:any;
  constructor(private api:ProductserviceService,private router:Router,
    private reviewservice:ReviewserviceService,private usernameservice:UsernameserviceService) 
    {
       this.alternativeemail= localStorage.getItem("emailidd")
      this.getusername();
     }
    emailid:any;
  ngOnInit(): void {
    
    
    this.api.getproduct().subscribe(res=>{
      this.productlist=res;
      if(this.productlist==null)
      {
        this.msgstrr="no item Found"
        this.check=false;
      
      }
      
    })



  }
  getusername()
  {
    this.emailid=this.usernameservice.getusername();
    this.emailid=this.alternativeemail
    console.log(this.usernameservice.getusername());

    console.log(this.emailid)
  }
    searchbyname(event:any)
    {
        this.searchTerm=(event.target as HTMLInputElement).value;
        console.log(this.searchTerm);
        this.api.searchstr.next(this.searchTerm);
        this.searchname=this.searchTerm;
    }
    searchbybrand(event:any){
       this.searchBrand=(event.target as HTMLInputElement).value;
       console.log(this.searchBrand);
       this.api.searchbrandstr.next(this.searchBrand);
       this.searchbrand=this.searchBrand;
  
    }
    
    addreview(code:any){
      console.log(code);
      this.reviewservice.postcode(code);
      localStorage.setItem("alternativecode",code)
      this.router.navigate(["/addreview"]);
    }

    allreview(code:any){
      this.reviewservice.postcode(code);
    
      this.router.navigate(["/allreview"]);
    }

    logout(){
      localStorage.removeItem('token');
      localStorage.removeItem('emailidd')
      localStorage.removeItem('alternativecode')
      window.location.href = "/login"
      
    }
}
