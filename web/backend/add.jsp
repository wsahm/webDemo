<%@page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<meta charset="utf-8">
		<style>
			body{
				background:#f4ecf5;
				
			}
			#top{
				background:#0c6cba;
			}
			h2{
				font-familyt:微软雅黑;
				text-align:center;
				padding-bottom:20px;
				border-bottom:2px solid #000;
			}
			form td{
				margin:0px 10px 0px;
			}
		</style>
	</head>
	<body>
		<div id="top">
			<br/>
		</div>
		<h2>添加商品信息</h2>
		<form action="${pageContext.request.contextPath}/Servlete" method="post">
			<table align="center" border="1" bordercolor="red" 
			bgcolor="lightgray" cellspacing="0">
				<tr>
					<td>商品名称</td>
					<td><input type="text" name="name"/><td>
				</tr>
				<tr>
					<td>商品种类</td>
					<td>
						<select name="zl">
							<option value="sjsm">手机数码</option>
							<option value="qc">汽车</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>商品单价</td>
					<td><input type="text" name="danjia"/><td>
				</tr>
				<tr>
					<td>库存数量</td>
					<td><input type="text" name="kc"/><td>
				</tr>
				<tr>
					<td>商品描述</td>
					<td>
						<textarea name="desc"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="添加商品"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>