import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProductReview } from './product-review';

@Injectable({
  providedIn: 'root'
})
export class RegisterReviewService {

  constructor(private _http:HttpClient) { }

  public RegisterReview(productReview:ProductReview):Observable<any>
{
  console.log(productReview.productcode)
  return this._http.post<any>("http://localhost:2222/registerreview",productReview);
}
}
