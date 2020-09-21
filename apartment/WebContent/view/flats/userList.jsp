<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XX系统 - 用户信息管理</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/lib/font-awesome/css/font-awesome.css">
	
</head>
<body>
	<div class="box">
		<h3>用户信息管理</h3>
		<div class="actions">
			<div>
				<a class="btn btn-primary" href="${pageContext.request.contextPath }/userAdd">添加用户信息</a>
			</div>
		<div id="d1"	class="clo-md-4">
			<form action="<c:url value="/userKeywords"/>" >
				<select name="field">
					<option value="uname">账户名称</option>
					<option value="upassword">密码</option>
				</select>
				<input type="text" name="keywords" placeholder="关键字模糊查询">
				<input type="submit" value="查询">
			</form>
		</div>
		</div>
		<table class="list">
			<tr>
				<th>编号</th>
				<th>账户</th>
				<th>密码</th>
				<th>真实姓名</th>
				<th>添加时间</th>
				<th>用户状态</th>
				<th>操作</th>
				
			</tr>
			<c:forEach items="${user }" var="user">
				<tr>
					<td>${user.uid }</td>
					<td>${user.uname }</td>
					<td>${user.upassword }</td>
					<td>${user.urealname }</td>
					<td>${user.uaddTime }</td>
					<td>${user.ustatus }</td>
					<td><a class="fa fa-info" title="详情" href="${pageContext.request.contextPath }/userInfo?uid=${user.uid}"></a>
						&nbsp;&nbsp; <a class="fa fa-pencil" title="编辑" href="${pageContext.request.contextPath }/userUpdate?uid=${user.uid}"></a>
						&nbsp;&nbsp; <a class="fa fa-remove" title="删除" href="javascript:void(0)"
						onclick="confirmDelete(${user.uid})"></a></td>
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
	function confirmDelete(uid) {
		if (confirm("确定要删除码？")) {
			location.href = '${pageContext.request.contextPath }/userDel?uid=' + uid
					return true;
		}else{
			return false;
		}
	}
	</script>
</body>
</html>