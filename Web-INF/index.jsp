<!doctype html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Send Request</title>

<!-- Bootstrap 3.3.4 -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<!-- <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"rel="stylesheet" type="text/css" /> -->

</head>

<body>


	<div align="center" style="border: 1px solid">
		<h1 style="color: maroon; font-size: 60px;">Load Balancer</h1>
	</div>


	<div class="col-md-12" align="center" style="margin-top: 80px">

		<form id="login_form" action="<%=request.getContextPath()%>/sendRequest" method="post">
			
			<div class="col-md-offset-4">
				<div class="col-md-5">
					<input type="email" class="form-control input-lg"  name="email" placeholder="email" required="required"/>
				</div>
				<div class="col-md-2">
					<input type="submit" class="btn btn-danger btn-flat btn-lg pull-left" value="Request"required="required" />
				</div>
			</div>
			
		</form>

	</div>
	
	<hr style="margin-top: 25%"/>	
		
	<div align="center">
		<h4 style="color: black; font-size: 20px;">Deep (120020107060)</h4>
	</div>
	
		
    <!-- Bootstrap 3.3.2 JS -->
    <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

</body>

</html>