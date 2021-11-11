<%@page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<meta charset="utf-8">
		<style>
			body{
				background:#32323A;
				font-family:微软雅黑;
				margin:0px;
			}
			#menu-bar div{
				font-size:20px;
				letter-spacing:3px;
				border-bottom:1px solid #CCC;
				text-indent:15px;
				padding:5px 0px;
				
			}
			#menu-bar div a{
				color:#fff;
				text-decoration:none;
			}
			#menu-bar div:first-child{
				border-top:1px solid #CCC;
			}
			#menu-bar div:hover{/*鼠标悬停事件*/
				background:#797981;
			}
		</style>
	</head>
	<body>
		<div id="menu-bar">
			<div>
				<a href="${pageContext.request.contextPath}/backend/#" target="rightFrame">&gt; 商品管理</a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath}/backend/add.jsp" target="reightFrame" >&gt; 商品添加</a>
			</div>
		</div>
	</body>
</html>