<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XX系统 - 租赁合同管理</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/lib/font-awesome/css/font-awesome.css">
</head>
<body>
	<div class="box">
		<h3>租赁合同管理</h3>
		<div class="actions">
			<div>
				<a class="btn btn-primary" href="${pageContext.request.contextPath }/contractAdd">添加租赁合同信息</a>
			</div>
			<div id="d1"	class="clo-md-4">
			<form action="<c:url value="/contractKeywords"/>" >
				<select name="field">
					<option value="cid">编号</option>
					<option value="cnum">合同号</option>
				</select>
				<input type="text" name="keywords" placeholder="关键字模糊查询">
				<input type="submit" value="查询">
			</form>
		</div>
		</div>

		<table class="list">
			<tr>
				<th>编号</th>
				<th>合同号</th>
				<th>房屋编号</th>
				<th>租户编号</th>
				<th>添加时间</th>
				<th>租赁开始时间</th>
				<th>租赁结束时间</th>
				<th>房租总额</th>
				<th>付款方式</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${contract }" var="contract">
				<tr>
					<td>${contract.cid }</td>
					<td>${contract.cnum }</td>
					<td>${contract.chid }</td>
					<td>${contract.clid }</td>
					<td>${contract.ctime }</td>
					<td>${contract.cstartTime }</td>
					<td>${contract.cendTime }</td>
					<td>${contract.ctotalMoney }</td>
					<td>${contract.cpayType }</td>
					<td><a class="fa fa-info" title="详情" href="${pageContext.request.contextPath }/contractInfo?cid=${contract.cid}"></a>
						&nbsp;&nbsp; <a class="fa fa-pencil" title="编辑" href="${pageContext.request.contextPath }/contractUpdate?cid=${contract.cid}"></a>
						&nbsp;&nbsp; <a class="fa fa-remove" title="删除" href="javascript:void(0)"
						onclick="confirmDelete(${contract.cid})"></a></td>
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
	function confirmDelete(cid) {
		if (confirm("确定要删除码？")) {
			location.href = '${pageContext.request.contextPath }/contractDel?cid=' + cid
					return true;
		}else{
			return false;
		}
	}
	</script>
</body>
</html>