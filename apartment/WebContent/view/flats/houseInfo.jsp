<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XX系统 - 房屋信息详情查看</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>房屋信息详情</h3>
	<form action="#" method="post">
		<table class="form-table">
			<tr>
				<td class="label">编号</td>
				<td class="detail">
					${house.hid }
				</td>
			</tr>
			<tr>
				<td class="label">房屋地址</td>
				<td colspan="3" class="detail">
					${house.haddress }
				</td>
			</tr>
			<tr>
				<td class="label">楼层</td>
				<td colspan="3" class="detail">
					${house.hfloor }
				</td>
			</tr>
			<tr>
				<td class="label">房间号</td>
				<td colspan="3" class="detail">
					${house.hroomNum }
				</td>
			</tr>
			<tr>
				<td class="label">面积</td>
				<td colspan="3" class="detail">
					${house.harea }
				</td>
			</tr>
			<tr>
				<td class="label">朝向</td>
				<td colspan="3" class="detail">
					${house.hdir }
				</td>
			</tr>
			<tr>
				<td class="label">装修类型</td>
				<td colspan="3" class="detail">
					${house.hdeco }
				</td>
			</tr>
			<tr>
				<td class="label">是否双气</td>
				<td colspan="3" class="detail">
					${house.hair }
				</td>
			</tr>
			<tr>
				<td class="label">价格</td>
				<td colspan="3" class="detail">
					${house.hprice }
				</td>
			</tr>
			<tr>
				<td class="label">出租状态</td>
				<td colspan="3" class="detail">
					${house.hrentStatus }
				</td>
			</tr>
			<tr>
				<td class="label">房屋图片路径</td>
				<td colspan="3" class="detail">
					${house.himage }
				</td>
			</tr>
			<tr>
				<td class="label">添加时间</td>
				<td colspan="3" class="detail">
					${house.haddTime }
				</td>
			</tr>
			<tr>
				<td class="label">更新时间</td>
				<td colspan="3" class="detail">
					${house.hupdateTime }
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