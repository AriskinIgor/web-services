<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<script lang="javascript" src="${pageContext.request.contextPath}/protected/js/jquery-2.1.1.js"></script>
<script lang="javascript" src="${pageContext.request.contextPath}/protected/js/webclient.js"></script>
<script lang="javascript" src="${pageContext.request.contextPath}/protected/js/json2.js"></script>
</head>
<body>
	<h1>Add book</h1>
	<div id="error"></div>
	<p>
		Book Name : <input type="text" id="name" />
	</p>
	<p>
		Description : <input type="text" id="description" />
	</p>
	<p>
		Author : <input type="text" id="author" />
	</p>
	<input type="button" value="Add Book" onclick="addBook()" />
</body>
</html>