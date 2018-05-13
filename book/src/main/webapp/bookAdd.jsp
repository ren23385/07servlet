<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>书籍添加</title>
<!-- 1、 告诉浏览器表缩放 -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="bower_components/bootstrap/dist/css/bootstrap.css"
	rel="stylesheet" type="text/css" />

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
					action="bookAdd">
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
							书籍种类： </label>
						<div class="col-sm-10">
							<select class="form-control">
								<option value="volvo">计算机编程</option>
								<option value="saab">基础烹饪</option>
								<option value="opel">数学</option>
								<option value="audi">文学</option>
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label for="bookauthor" class="col-sm-2 control-label">
							出版日期： </label>
						<div class="col-sm-10">
							<input type="date" class="form-control" id="bookdate"
								name="date">
						</div>
					</div>
					
					

					<div class="form-group">
						<label for="bookpage" class="col-sm-2 control-label">
							书籍图片： </label>
						<div class="col-sm-10">
							<input type="file" class="form-control" id="bookphoto" name="photo">
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
</body>
</html>