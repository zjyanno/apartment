<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XX系统 - 房屋信息管理</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/lib/font-awesome/css/font-awesome.css">
</head>
<body>
	<div class="box">
		<h3>房屋信息管理</h3>
		<div class="actions">
			<div>
				<a class="btn btn-primary" href="${pageContext.request.contextPath }/houseAdd">添加房屋信息</a>
			</div>
			<div id="d1"	class="clo-md-4">
			<form action="<c:url value="/houseKeywords"/>" >
				<select name="field">
					<option value="hid">编号</option>
					<option value="hfloor">楼层</option>
				</select>
				<input type="text" name="keywords" placeholder="关键字模糊查询">
				<input type="submit" value="查询">
			</form>
		</div>
		</div>

		<table class="list">
			<tr>
				<th>编号</th>
				<th>房屋地址</th>
				<th>楼层</th>
				<th>房间号</th>				
				<th>面积</th>
				<th>朝向</th>
				<th>装修类型</th>
				<th>是否双气</th>
				<th>价格</th>
				<th>出租状态</th>
				<th>房屋图片路径</th>
				<th>添加时间</th>
				<th>更新时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${house }" var="house">
				<tr>
					<td>${house.hid }</td>
					<td>${house.haddress }</td>
					<td>${house.hfloor }</td>
					<td>${house.hroomNum }</td>
					<td>${house.harea }</td>
					<td>${house.hdir }</td>
					<td>${house.hdeco }</td>
					<td>${house.hair }</td>
					<td>${house.hprice }</td>
					<td>${house.hrentStatus }</td>
					<td>${house.himage }</td>
					<td>${house.haddTime }</td>
					<td>${house.hupdateTime }</td>
					<td><a class="fa fa-info" title="详情" href="${pageContext.request.contextPath }/houseInfo?hid=${house.hid }"></a>
						&nbsp;&nbsp; <a class="fa fa-pencil" title="编辑" href="${pageContext.request.contextPath }/houseUpdate?hid=${house.hid}"></a>
						&nbsp;&nbsp; <a class="fa fa-remove" title="删除" href="javascript:void(0)" 
						onclick="confirmDelete(${house.hid})"></a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="pager-info">
			<div>共有 ${total } 条记录，第 ${pageNo }/${pageCount } 页</div>
			<div>
				<ul class="pagination">
					<li class="paginate_button previous disabled }"><a href="${pageContext.request.contextPath }/houseList?pageNo=${pageNo-1}">上一页</a>
					</li>
					<li class="paginate_button active"><a href="#">1</a></li>
					<li class="paginate_button next disabled"><a href="${pageContext.request.contextPath }/houseList?pageNo=${pageNo+1}">下一页</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<script src="../../lib/jquery/jquery.js"></script>
	<script>
		function confirmDelete(hid) {
			if (confirm("确定要删除码？")) {
    			location.href = '${pageContext.request.contextPath }/houseDel?hid=' + hid
    					return true;
    		}else{
    			return false;
    		}
    	}
	</script>
</body>
</html>