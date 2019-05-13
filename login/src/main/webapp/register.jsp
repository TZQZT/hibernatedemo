<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
<head>


	<title>注册</title>

</head>

<body>
<h1>注            册</h1>
<hr>
<form action="RegistServlet" method="post">
	<table class="centertable">
		<tr>
			<td class="td1">用 户 名：</td>
			<td class="td2"><input class="text1" type="text" name="username" /></td>
		</tr>
		<tr>
			<td class="td1">密    码：</td>
			<td class="td2"><input class="text1" type="password" name="password" /></td>
		</tr>
		<tr>
			<td class="td1">确认密码：</td>
			<td class="td2"><input class="text1" type="password" name="repassword" /></td>
		</tr>
		<tr>
			<td colspan="2"><input class="button" type="submit" value="注册" onchange="checkpwd()" />
				<input class="button" type="button" onclick="javascript:history.back(-1);" value="返回" /></td>
		</tr>
	</table>
</form>
</body>
</html>
