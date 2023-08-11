function EnrollStudent()
{   event.preventDefault;
    const Name = document.getElementById("Name").value;
    const Email= document.getElementById("Email").value;
    const Website = document.getElementById("Website").value;
    const ImageLink= document.getElementById("ImageLink").value;
    var Gender;
    console.log("a");
    if(document.getElementById("Male").checked==true)
    {
        Gender="Male";
    }
    else if(document.getElementById("Female").checked==true)
    {
        Gender="Female";
    }
    var Skills = "";
    if(document.getElementById("Java").checked==true)
    {   
        Skills=Skills+"Java";
    }
    
    if(document.getElementById("Html").checked==true)
    {   
        if(Skills!="")
            {
                Skills=Skills+",";
            }
        Skills=Skills+"Html";
    }
    
    if(document.getElementById("Css").checked==true)
    {   if(Skills!="")
    {
        Skills=Skills+",";
    }
        Skills=Skills+"Css";
    }
    
    var element = document.getElementById("id-card-list");
    var li = document.createElement("li");
    element.appendChild(li);

    var listcarddb =document.createElement("div");
    li.appendChild(listcarddb);
    listcarddb.classList.add("myidborder");

    var listcarda = document.createElement("div");
    li.appendChild(listcarda);
    li.classList.add("ul");
    listcarda.classList.add("row");


    
    var listcard = document.createElement("div");
    li.appendChild(listcard);
    listcard.classList.add("col-sm-8");
    listcard.classList.add("border-right-id")

    listcarda.appendChild(listcard);
    
    var liMain = document.createElement("ul");
    liMain.classList.add("description");
    listcard.appendChild(liMain);

    var info = document.createElement("info");
    liMain.appendChild(info);

    var liSub1 = document.createElement("li");
    liSub1.classList.add("details");
    var name1 = document.createTextNode(Name);
    

    var bo = document.createElement('b');
    liSub1.appendChild(bo);

    bo.appendChild(name1);
    info.appendChild(liSub1);

    var liSub4 = document.createElement("li");
    liSub4.classList.add("details");
    var gender1 = document.createTextNode(Gender);
    liSub4.appendChild(gender1);
    info.appendChild(liSub4);

    var liSub2 = document.createElement("li");
    liSub2.classList.add("details");
    var email1 = document.createTextNode(Email);
    liSub2.appendChild(email1);
    info.appendChild(liSub2);

    var liSub3 = document.createElement("li");
    var sublink = document.createElement("a")
    liSub3.classList.add("details");
    var web1 = document.createTextNode(Website);
    sublink.href = Website;
    sublink.target = "_blank";
    liSub3.appendChild(sublink);
    sublink.appendChild(web1);
    info.appendChild(liSub3);

    var liSub5 = document.createElement("li");
    liSub5.classList.add("details");
    var skills1 = document.createTextNode(Skills);
    liSub5.appendChild(skills1);
    info.appendChild(liSub5);

    var listcard2 = document.createElement("div");
    element .appendChild(listcard2);
    listcard2.classList.add("col-sm-4");
    // listcard.classList.add("border-right-id");

    var img = document.createElement("img");
    img.src = ImageLink;
    listcard2.appendChild(img);

    listcarda.appendChild(listcard2);

    // liMain.appendChild(listcard2);
    
    

   


}
function Validation()
{
    var vName = document.getElementById("Name").value;
    var vEmail= document.getElementById("Email").value;
    var vWebsite = document.getElementById("Website").value;
    var vImageLink= document.getElementById("ImageLink").value;
    
    
    if(vName=="")
    {   
        document.getElementById('username').innerHTML="Please Enter Valid User Name";
        
       return false;
    }
    if(vName.length>30)
    {   
        document.getElementById('username').innerHTML="User Name Cant be greater than 30";
        
       return false;
    }
    if(!isNaN(vName))
    {   
        document.getElementById('username').innerHTML="Only Characters Allowed";
        
       return false;
    }
 
    if(vEmail.indexOf('@')<=0)
    {
        document.getElementById('useremail').innerHTML="Enter Valid Email Address";
        return false;
    }
    if((vEmail.charAt(vEmail.length-4)!='.')&& (vEmail.charAt(vEmail.length-3))!='.')
    {
        document.getElementById('useremail').innerHTML="Enter Valid Email ID";
        return false;
    }
  

 
    if(vWebsite=="")
    {
        document.getElementById('userwebsite').innerHTML="Enter Valid website Address";
        return false;
    }
    if(vImageLink=="")
    {
        document.getElementById("userimage").innerHTML="Enter Valid Link";
        return false;
    }
    else if(isNaN(vName)||(vName.length>2))
    {
        document.getElementById('username').innerHTML="";   
        document.getElementById('useremail').innerHTML="";
        document.getElementById('userwebsite').innerHTML="";
        document.getElementById("userimage").innerHTML="";
        EnrollStudent();
        
    }


}
function Clear()
{   document.getElementById("Name").value="";
    document.getElementById("Email").value="";
    document.getElementById("Website").value="";
    document.getElementById("ImageLink").value="";
    document.getElementById("Male").checked=false;
    document.getElementById("Female").checked=false;
    document.getElementById("Html").checked=false;
    document.getElementById("Java").checked=false;
    document.getElementById("Css").checked=false;
}