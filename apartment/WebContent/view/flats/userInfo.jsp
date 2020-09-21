<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XX系统 - 用户信息详情查看</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>用户信息详情</h3>
	<form action="#" method="post">
		<table class="form-table">
			<tr>
				<td class="label">编号</td>
				<td class="detail">
					${user.uid }
				</td>
			</tr>
			<tr>
				<td class="label">账户名称</td>
				<td colspan="3" class="detail">
					${user.uname }
				</td>
			</tr>
			<tr>
				<td class="label">密码</td>
				<td colspan="3" class="detail">
					${user.upassword }
				</td>
			</tr>
			<tr>
				<td class="label">真实姓名</td>
				<td colspan="3" class="detail">
					${user.urealname }
				</td>
			</tr>
			<tr>
				<td class="label">添加时间</td>
				<td colspan="3" class="detail">
					${user.uaddTime }
				</td>
			</tr>
			<tr>
				<td class="label">用户状态</td>
				<td colspan="3" class="detail">
					${user.ustatus }
				</td>
			</tr>
			
		</table>
		<div class="buttons">
			<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
		</div>
	</form>
</div>
</body>
</html>