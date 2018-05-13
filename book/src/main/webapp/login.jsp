<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login</title>

<!-- 1、 告诉浏览器表缩放 -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="bower_components/jquery-validation-bootstrap-tooltip/jquery-validate.bootstrap-tooltip.js">
</script>
<script type="text/javascript" src="/bower_components/jquery-validation/dist/jquery.validate.js">
</script>
<style type="text/css">
.container-fluid {
	width: 40%;
	position: absolute;
	left: 50%;
	top: 50%;
	margin-left: -304px;
	margin-top: -123px;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<form class="form-horizontal" role="form" method="post" action="Login">
					<div class="form-group">
						<div class="col-sm-10">
							用户名：<input type="text" class="form-control" id="username" 
							placeholder="Please input your username" name="name" value="<%=request.getAttribute("name")==null?"":request.getAttribute("name")%>">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-10">
							密码：<input type="password" class="form-control"
								id="inputPassword" placeholder="please input your password" name="pwd">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Sign in</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="bower_components/jquery/dist/jquery.js">
	</script>
	<script type="text/javascript" src="bower_components/bootstrap/dist/js/bootstrap.min.js">
	</script>
	<script type="text/javascript" src="bower_components/jquery/dist/jquery.min.js">
	</script>
	
	<script type="text/javascript">

	$function()




	</script>
	
</body>
</html>