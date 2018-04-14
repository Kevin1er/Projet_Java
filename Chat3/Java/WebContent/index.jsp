<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.sql.ResultSet"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Simple Chat</title>
<script language="javascript" src="jquery-1.2.6.min.js"></script>
<script language="javascript" src="jquery.timers-1.0.0.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
 




<script type="text/javascript">
 
 
var url = '${pageContext.request.contextPath}/refresh_serv'
 
$(document).ready(function() {
	
$.ajaxSetup({ cache: false }); 
 
 
setInterval(function() {$("#displayarea").load(url); }, 300);


 
});
 
</script>


<link href="chat.css" rel="stylesheet">



</head>
    

  	<body>
	<form id="form1" name="form1"  role="form" method="post" action="${pageContext.request.contextPath}/message_serv">
	
	<div >Bonjour,User</div>
	<div class="refresh" id="displayarea">

	<!-- <p><span>User:</span>Hello</p>
	<p><span>User2:</span>Hello User</p>
	<p><span>User:</span>Good?</p>
	 -->
	 <% 
	
		%>
 <div id='content'>
</div>
<!-- ici message -->
	</div>
	<input name="message" type="text" id="textb"/>
	<button type="submit" class="btn" id="post_button" >Send</button>
	
	
	

	</form>
	
	
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript">

 var form = $('#form1');
 form.submit(function () {

 $.ajax({
 type: form.attr('method'),
 url: form.attr('action'),
 data: form.serialize(),
 success: function (data) {
 var result=data;
 $('#content').html(result);

//clear fields
 $('input[type="text"],textarea').val('');
 
 }
 });

 return false;
 }); </script>
	
	


	
	</body>
	</html>
  
</html>
