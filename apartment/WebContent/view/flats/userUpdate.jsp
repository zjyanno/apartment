<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XX系统 - 用户信息修改</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/lib/font-awesome/css/font-awesome.css">
</head>
<body>
	<div class="box">
		<h3>修改用户信息</h3>
		<form action="<c:url value="/userUpdate"/>" method="post">
		<!-- 隐藏uid -->
		<input type="hidden" name="uid" value="${user.uid }">
			<table class="form-table">
<tr>
					<td>账户</td>
					<td colspan="3" class="control"><input type="text"
						name="uname" placeholder="账户" value="${user.uname }"></td>
				</tr>
				<tr>
					<td>密码</td>
					<td colspan="3" class="control"><input type="text"
						name="upassword" placeholder="密码" value="${user.upassword }"></td>
				</tr>
				<tr>
					<td>真实姓名</td>
					<td colspan="3" class="control"><input type="text"
						name="urealname" placeholder="真实姓名" value="${user.urealname }"></td>
				</tr>
				<tr>
					<td>用户状态</td>
					<td colspan="3" class="control"><input type="text"
						name="ustatus" placeholder="用户状态" value="${user.ustatus }"></td>
				</tr>
				
			</table>
			<div class="buttons">
				<input class="btn btn-primary va-bottom" type="submit" value="保存">&nbsp;&nbsp;
				<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
			</div>
		</form>
	</div>
</body>
</html>