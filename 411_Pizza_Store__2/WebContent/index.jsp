<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->

<head>
<meta charset="utf-8">
<title>411 PIZZA STORE</title>
<script src="script.js"></script>

<link rel="stylesheet" type="text/css" href="style.css" />
</head>

<body onload="checkUserCookie();">

<div class="container">
	<section id="content">
		
		<form method="get" id="myform" name="frmData" action="login">
			
			<h1>411-PIZZA</h1>
			
			<div>
				<input type="text" name="userName" id="un" placeholder="Username" />
			</div>
			
			<div>
				<input name="password" id="pw" type="password" placeholder="Password" />
			</div>
			
			<div>
			
			 <input type="button" value="login" name="cmdEnter" onclick="checkForm();"/>
			 <input type="reset" name="cmdReset" value="Clear" onclick="clearCookies();"/>
		
								
			<!-- <input type="submit" value="Log in" /> -->	
				
			<!-- <a href="#">Lost your password?</a> -->	
				<a href="signup.htm">New User? Register</a>
			
			</div>
		
		</form><!-- form -->
		
		<div class="button">
		
		<!-- <a href="#">Download source file</a> -->	
		
		</div><!-- button -->
	
	</section><!-- content -->
</div><!-- container -->
</body>
</html>
