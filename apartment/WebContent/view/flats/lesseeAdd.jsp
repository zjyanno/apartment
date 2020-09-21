<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XX系统 - 租户信息添加</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/lib/font-awesome/css/font-awesome.css">
</head>
<body>
	<div class="box">
		<h3>租户信息添加</h3>
		<form action="<c:url value="/lesseeAdd"/>" method="post">
			<table class="form-table">
				<tr>
					<td>姓名</td>
					<td colspan="3" class="control"><input type="text"
						name="lname" placeholder="姓名"></td>
				</tr>
				<tr>
					<td>手机号</td>
					<td colspan="3" class="control"><input type="text"
						name="ltel" placeholder="手机号"></td>
				</tr>
				<tr>
					<td>性别</td>
					<td colspan="3" class="control"><input type="text"
						name="lsex" placeholder="性别"></td>
				</tr>

				<tr>
					<td>籍贯</td>
					<td colspan="3" class="control"><input type="text" 
						name="lnp"	placeholder="籍贯"></td>
				</tr>
				<tr>
					<td>身份证号</td>
					<td colspan="3" class="control"><input type="text" 
						name="lidCard"	placeholder="身份证号"></td>
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