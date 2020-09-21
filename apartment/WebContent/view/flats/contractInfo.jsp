<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XX系统 - 租赁合同信息详情查看</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>租赁合同信息详情</h3>
	<form action="#" method="post">
		<table class="form-table">
			<tr>
				<td class="label">编号</td>
				<td class="detail">
					${contract.cid }
				</td>
			</tr>
			<tr>
				<td class="label">合同号</td>
				<td colspan="3" class="detail">
					${contract.cnum }
				</td>
			</tr>
			<tr>
				<td class="label">房屋编号</td>
				<td colspan="3" class="detail">
					${contract.chid }
				</td>
			</tr>
			<tr>
				<td class="label">租户编号</td>
				<td colspan="3" class="detail">
					${contract.clid }
				</td>
			</tr>
			<tr>
				<td class="label">添加时间</td>
				<td colspan="3" class="detail">
					${contract.ctime }
				</td>
			</tr>
			<tr>
				<td class="label">租赁开始时间</td>
				<td colspan="3" class="detail">
					${contract.cstartTime }
				</td>
			</tr>
			<tr>
				<td class="label">租赁结束时间</td>
				<td colspan="3" class="detail">
					${contract.cendTime }
				</td>
			</tr>
			<tr>
				<td class="label">房租总额</td>
				<td colspan="3" class="detail">
					${contract.ctotalMoney }
				</td>
			</tr>
			<tr>
				<td class="label">付款方式</td>
				<td colspan="3" class="detail">
					${contract.cpayType }
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