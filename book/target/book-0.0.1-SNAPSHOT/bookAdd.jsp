<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>书籍添加</title>
<!-- 1、 告诉浏览器表缩放 -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="bower_components/bootstrap/dist/css/bootstrap.css"
	rel="stylesheet" type="text/css" />
	
<link href="bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.css" rel="stylesheet" type="text/css" />

<style type="text/css">
.container-fluid {
	width: 45%;
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
					action="bookAdd" enctype="multipart/form-data">

					<div class="form-group">
						<label for="bookname" class="col-sm-2 control-label">
							书籍名称： </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="bookname" name="name">
						</div>
					</div>

					<div class="form-group">
						<label for="bookdesc" class="col-sm-2 control-label">
							书籍描述： </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="bookdesc" name="desc">
						</div>
					</div>

					<div class="form-group">
						<label for="bookauthor" class="col-sm-2 control-label">
							书籍作者： </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="bookauthor"
								name="author">
						</div>
					</div>

					<div class="form-group">
						<label for="bookauthor" class="col-sm-2 control-label">
							书籍价格： </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="bookprice"
								name="price">
						</div>
					</div>



					<div class="form-group">
						<label for="bookauthor" class="col-sm-2 control-label">
							书籍种类： </label>
						<div class="col-sm-10">
							<select class="form-control" name="tid" id="ele">
								<option value="1">计算机编程</option>
								<option value="2">基础烹饪</option>
								<option value="3">数学</option>
								<option value="4">文学</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="bookauthor" class="col-sm-2 control-label">
							出版日期： </label>
						<div class="col-sm-10">
							<input type="date" class="form-control" id="bookdate" name="date">
						</div>
					</div>



					<div class="form-group">
						<label for="bookpage" class="col-sm-2 control-label">
							书籍图片： </label>
						<div class="col-sm-10">
							<input type="file" class="form-control" id="bookphoto"
								name="photo">
						</div>
					</div>


					<div class="form-group">

						<label for="inputVcode" class="col-sm-2 control-label">
							验证码 ：</label>
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
							<button type="submit" class="btn btn-default">提交</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="bower_components/jquery/dist/jquery.js">
		
	</script>
	<script type="text/javascript"
		src="bower_components/bootstrap/dist/js/bootstrap.min.js">
		
	</script>
	<script type="text/javascript"
		src="bower_components/jquery/dist/jquery.min.js">
		
	</script>
	<script type="text/javascript"
		src="bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript"
		src="bower_components/bootstrap-datepicker/dist/locales/bootstrap-datepicker.zh-CN.min.js"></script>
	<script type="text/javascript"
		src="bower_components/jquery-validation/dist/jquery.validate.js"></script>
	<script type="text/javascript"
		src="bower_components/jquery-validation-bootstrap-tooltip/jquery-validate.bootstrap-tooltip.js"></script>



	<script type="text/javascript">
		$(function() {
			$("#vcodeImg").click(function(evt) {
				//不加不会换
				this.src = "vcode.png?t=" + Math.random();
			});
			//日期控件
			$('#bookdate').datepicker({
				format : 'yyyy-mm-dd',
				language : 'zh-CN',//提示中文界面
				autoclose : true
			//自动关闭
			});

		});
	</script>
</body>
</html>