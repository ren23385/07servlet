<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login</title>

<!-- 1、 告诉浏览器表缩放 -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="bower_components/bootstrap/dist/css/bootstrap.css"
	rel="stylesheet" type="text/css" />
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
				<form class="form-horizontal" role="form" method="post"
					action="Login" id="loginform">
					<%
						if (request.getAttribute("msg") != null) {
					%>
					<div class="alert alert-warning" role="alert"><%=request.getAttribute("msg")%></div>
					<%
						}
					%>



					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名：
						</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="username"
								placeholder="Please input your username" name="name"
								value="<%=request.getAttribute("name") == null ? "" : request.getAttribute("name")%>">
						</div>
					</div>


					<div class="form-group">

						<label for="bookname" class="col-sm-2 control-label"> 密码：
						</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="inputPassword"
								placeholder="please input your password" name="pwd">
						</div>
					</div>

					<div class="form-group">

						<label for="inputVcode" class="col-sm-2 control-label">
							验证码 </label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputVcode"
								name="vcode" maxlength="4" />

						</div>
						<div class="col-sm-4">
							<img alt="" src="vcode.png" id="vcodeImg" title="单击换图片">
						</div>
					</div>


					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Login</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="bower_components/jquery/dist/jquery.js"></script>
	<script type="text/javascript"
		src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="bower_components/jquery-validation/dist/jquery.validate.js">
		</script>
		<script type="text/javascript" src="bower_components/jquery-validation-bootstrap-tooltip/jquery-validate.bootstrap-tooltip.js">
		</script>

	<script type="text/javascript">
		$(function() {
			$("#vcodeImg").click(function(evt) {
				//不加不会换
				this.src = "vcode.png?t=" + Math.random();
			});
			//验证
			$("#loginform").validate({
				rules : {
					name : {
						required : true
					},
					pwd : {
						required : true
					}
				},
				messages : {
					name : "必须填写",
					pwd : "必须填写"
				},
				tooltip_options : {
					name : {
						placement : 'bottom'
					},
					pwd : {
						placement : 'bottom'
					}
				}
			});

		});
	</script>
</body>
</html>