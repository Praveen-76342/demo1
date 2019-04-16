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
 .loginbox{
 margin-left:300px;
 margin-top:90px;
     height:200px;
     width:300px;
     background: #DCDCDC;
     padding-left: 100px;
     padding-top:50px}</style>
<body>
<div class="loginbox">
${message}
<form action="userloginProcess" modelAttribute="login" method="post">
username: <input type="text" name="username" id="username"/><br><br><br>
password:  <input type="password" name="password" id="password"/><br><br><br>
<button id="login" name="login" >login</button>
</form>
</div>
</body>
</html>