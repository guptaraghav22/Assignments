import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.getstat()
  }

value:any;
  getstat()
  {
    
     this.http.get<any>("http://localhost:2222/count").subscribe(data=>{
     console.log(data);
     this.value=data


     })
    
    
    }
  }
