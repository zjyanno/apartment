<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XX系统 - 租户信息管理</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/lib/font-awesome/css/font-awesome.css">
</head>
<body>
	<div class="box">
		<h3>租户信息管理</h3>
		<div class="actions">
			<div>
				<a class="btn btn-primary" href="${pageContext.request.contextPath }/lesseeAdd">添加租户信息</a>
			</div>
		</div>

		<table class="list">
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>手机号</th>
				<th>性别</th>
				<th>籍贯</th>
				<th>身份证号</th>
				<th>添加时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${lessee }" var="lessee">
				<tr>
					<td>${lessee.lid }</td>
					<td>${lessee.lname }</td>
					<td>${lessee.ltel }</td>
					<td>${lessee.lsex }</td>
					<td>${lessee.lnp }</td>
					<td>${lessee.lidCard }</td>
					<td>${lessee.laddTime }</td>
					<td><a class="fa fa-info" title="详情" href="${pageContext.request.contextPath }/lesseeInfo?lid=${lessee.lid}"></a>
						&nbsp;&nbsp; <a class="fa fa-pencil" title="编辑" href="${pageContext.request.contextPath }/lesseeUpdate?lid=${lessee.lid}"></a>
						&nbsp;&nbsp; <a class="fa fa-remove" title="删除" href="javascript:void(0)"
						onclick="confirmDelete(${lessee.lid})"></a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="pager-info">
			<div>共有 1 条记录，第 1/1 页</div>
			<div>
				<ul class="pagination">
					<li class="paginate_button previous disabled }"><a href="#">上一页</a>
					</li>
					<li class="paginate_button active"><a href="#">1</a></li>
					<li class="paginate_button next disabled"><a href="#">下一页</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<script src="../../lib/jquery/jquery.js"></script>
	<script>
	function confirmDelete(lid) {
		if (confirm("确定要删除码？")) {
			location.href = '${pageContext.request.contextPath }/lesseeDel?lid=' + lid
					return true;
		}else{
			return false;
		}
	}
	</script>
</body>
</html>