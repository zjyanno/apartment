<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XX系统 - 房屋信息修改</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/lib/font-awesome/css/font-awesome.css">
</head>
<body>
	<div class="box">
		<h3>修改房屋信息</h3>
		<form action="<c:url value="/houseUpdate"/>" method="post">
		<!-- 隐藏hid -->
		<input type="hidden" name="hid" value="${house.hid }">
		<input type="hidden" name="haddTime"  value="${house.haddTime }">
			<table class="form-table">
<tr>
					<td>房屋地址</td>
					<td colspan="3" class="control"><input type="text"
						name="haddress" placeholder="房屋地址" value="${house.haddress }"></td>
				</tr>
				<tr>
					<td>楼层</td>
					<td colspan="3" class="control"><input type="text"
						name="hfloor" placeholder="楼层" value="${house.hfloor }"></td>
				</tr>
				<tr>
					<td>房间号</td>
					<td colspan="3" class="control"><input type="text"
						name="hroomNum" placeholder="房间号" value="${house.hroomNum }"></td>
				</tr>
				<tr>
					<td>面积</td>
					<td colspan="3" class="control"><input type="text"
						name="harea" placeholder="面积" value="${house.harea }"></td>
				</tr>
				<tr>
					<td>朝向</td>
					<td colspan="3" class="control"><input type="text" name="hdir"
						placeholder="朝向" value="${house.hdir }"></td>
				</tr>
				<tr>
					<td>装修类型</td>
					<td colspan="3" class="control"><input type="text"
						name="hdeco" placeholder="装修类型" value="${house.hdeco }"></td>
				</tr>
				<tr>
					<td>是否双气</td>
					<td colspan="3" class="control"><input type="text" name="hair"
						placeholder="是否双气" value="${house.hair }"></td>
				</tr>
				<tr>
					<td>价格</td>
					<td colspan="3" class="control"><input type="text"
						name="hprice" placeholder="价格" value="${house.hprice }"></td>
				</tr>
				
				<tr>
					<td>出租状态</td>
					<td colspan="3" class="control"><input type="text"
						name="hrentStatus" placeholder="价格" value="${house.hrentStatus }"> 
						<!-- <select>
							<option>出租状态</option>
							<option>已出租</option>
							<option>未出租</option>
						</select> -->
					</td>
				</tr>
				<tr>
					<td>房屋图片路径</td>
					<td colspan="3" class="control"><input type="text"
						name="himage" placeholder="房屋图片路径" value="${house.himage }"></td>
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