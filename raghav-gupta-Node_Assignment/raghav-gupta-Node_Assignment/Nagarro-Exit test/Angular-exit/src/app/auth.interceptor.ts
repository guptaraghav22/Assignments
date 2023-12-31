import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";

import { Injectable } from "@angular/core";

import { Observable } from "rxjs";
import { LoginserviceService } from "./loginservice.service";


@Injectable()

export class AuthInterceptor implements HttpInterceptor{



    constructor(private loginService:LoginserviceService){



    }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        let newReq=req

        let token=this.loginService.getToken()

        console.log("INTERCEPTOR",token)

        if(token!=null){

            newReq=req.clone({setHeaders:{Authorization:`Bearer ${token}`}})

        }

        return next.handle(newReq)

    }

}