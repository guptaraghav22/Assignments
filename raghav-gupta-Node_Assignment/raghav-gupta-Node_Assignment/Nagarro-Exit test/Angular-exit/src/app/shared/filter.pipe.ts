import { Pipe, PipeTransform } from '@angular/core';
import { filter } from 'rxjs';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(value:any[],filterString:any,propertyname:string):any[] {
    
    const result: any=[];
    if(!value ||filterString==='' || propertyname==='')
    {
      return value;

    }
   
    value.forEach((a:any)=>{
      if(a[propertyname].trim().toLowerCase().includes(filterString.toLowerCase()))
      {
        result.push(a);
      }
    });
    return result;
  }

}
