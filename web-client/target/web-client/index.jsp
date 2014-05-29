<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h1>Авторизация</h1>
<form action="./" method="post">
	<table>
		<tr>
			<td><input name="login" value="" /></td>
		</tr>
		<tr>
			<td><input name="password" type="password" /></td>
			<td><button id="button" type="submit">Login</button></td>
		</tr>
		<tr>
			<%
				String error = (String) request.getAttribute("error");
				if (error != null) {
			%>
			<td><output name="error">
					<%=error%></output></td>
			<%
				}
			%>
		</tr>
	</table>
</form>
