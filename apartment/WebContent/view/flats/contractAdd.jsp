<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XX系统 - 房屋信息添加</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/lib/font-awesome/css/font-awesome.css">
</head>
<body>
	<div class="box">
		<h3>添加用户信息</h3>
		<form action="<c:url value="/contractAdd"/>" method="post">
			<table class="form-table">
				<tr>
					<td>合同号</td>
					<td colspan="3" class="control"><input type="text"
						name="cnum" placeholder="合同号"></td>
				</tr>
				<tr>
					<td>房屋编号</td>
					<td colspan="3" class="control"><input type="text"
						name="chid" placeholder="房屋编号"></td>
				</tr>
				<tr>
					<td>租户编号</td>
					<td colspan="3" class="control"><input type="text"
						name="clid" placeholder="租户编号"></td>
				</tr>

				<!-- <tr>
					<td>添加时间</td>
					<td colspan="3" class="control"><input type="text" 
						name="ustatus"	placeholder="添加时间"></td>
				</tr> -->
				<tr>
					<td>租赁开始时间</td>
					<td colspan="3" class="control"><input type="date" 
						name="cstartTime"	placeholder="租赁开始时间"></td>
				</tr>
				<tr>
					<td>租赁结束时间</td>
					<td colspan="3" class="control"><input type="date" 
						name="cendTime"	placeholder="租赁结束时间"></td>
				</tr>
				<tr>
					<td>房租总额</td>
					<td colspan="3" class="control"><input type="text" 
						name="ctotalMoney"	placeholder="房租总额"></td>
				</tr>
				<tr>
					<td>付款方式</td>
					<td colspan="3" class="control"><input type="text" 
						name="cpayType"	placeholder="付款方式"></td>
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