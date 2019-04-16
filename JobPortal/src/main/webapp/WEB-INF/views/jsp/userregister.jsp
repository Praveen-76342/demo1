<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<style>
 .registerbox1{
 margin-left:300px;
 margin-top:20px;
     height:450px;
     width:300px;
     background: #808080;
     padding-left: 100px;
     padding-top:50px;}
     </style>
<body>

<form onsubmit="return fvalidate()" action="userregisterProcess" modelAttribute="user" method="post">
<h2>User Register</h2><br>
username <input type="text" name="username" id="username"/><br>
<span id="iusername"></span><br><br>
password <input type="password" name="password" id="password"/><br>
<span id="ipassword"></span><br><br>
fullname <input type="text" name="fullname" id="fullname"/><br>
<span id="ifullname"></span><br><br>
phonenumber <input type="text" name="number" id="number" onkeypress="return isNumber(event)"/><br>
<span id="inumber"></span><br><br>
email <input type="text" name="email" id="email"/><br>
<span id="iemail"></span><br><br>
<input type="submit" value="submit" name="register"/>
</form>

<script>
function fvalidate()                                    
{ 
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var email = document.getElementById("email").value;
    var address =document.getElementById("address1").value;
    var phno = document.getElementById("number").value;
    
    
    if (username == "")                                  
    { 
        alert("enter username");
 
    }   
    if (fullname == "")                                  
    { 
        document.getElementById("ifullname").innerHTML ="*please fill the full name feild";
   
    }   
    if(email == "")
    	{
    	document.getElementById("iemail").innerHTML ="*Please fill email feild";
    	return false; 
    	}
     if (email.indexOf("@", 0) <= 0)                 
    { 
    	document.getElementById("iemail").innerHTML ="*email should contain @ atleast a letter before";
        return false; 
    } 
     
   
     if (email.indexOf(".", 0) <= 0)                 
    { 
    	document.getElementById("iemail").innerHTML ="*Email feild should contain a dot operator";
        return false; 
    } 
     if(phno =="")
    	 {
    	 document.getElementById("iphno1").innerHTML ="*Please fill the phone number";
     	return  false;
    	 }
   
     else if((phno.length<10) || (phno.length>10) )
    	 {
    	 document.getElementById("iphno1").innerHTML ="*Length of phone number must be equal to 10 only";
     	return  false;
    	 }
     
     if (npassword == "")                        
     { 
     	document.getElementById("inewpass1").innerHTML ="*please fill the password feild";
     	document.getElementById("iusername").innerHTML ="";
     	document.getElementById("iconpass").innerHTML ="";
     	document.getElementById("iemail").innerHTML ="";
     	document.getElementById("iphno").innerHTML ="";
     	document.getElementById("iname").innerHTML ="";
        return false; 
     }
      if ((npassword.length<8) || (npassword.length > 20))                       
     {
     	 document.getElementById("iname").innerHTML ="";
     	document.getElementById("inewpass1").innerHTML="* Length of password feild must be minimum 8 and maximim of 20";
     	document.getElementById("iusername").innerHTML ="";
     	document.getElementById("inewpass1").innerHTML ="";
     	document.getElementById("iemail").innerHTML ="";
     	document.getElementById("iphno").innerHTML ="";
         return false; 
     }
      var x=rpassword.localeCompare(npassword);    
      if(x==0)
     {return true;
     } 
      else{
    	  document.getElementById("iname").innerHTML ="";
       	document.getElementById("iconpass").innerHTML ="*passwords do not match";
       	document.getElementById("iusername").innerHTML ="";
       	document.getElementById("inewpass1").innerHTML ="";
       	document.getElementById("iemail").innerHTML ="";
       	document.getElementById("iphno1").innerHTML ="";
           return false; 
      }
    return true; 
}

function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48)|| (charCode > 57)) {
    	
        return false;
    }
    return true;
}
</script>
</body>
</html>