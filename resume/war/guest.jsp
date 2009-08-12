<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="net.fly78.guestbook.domain.GuestBookBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Daniel 的项目</title>
</head>
<body>
	<%
	
		List<GuestBookBean> l = (List<GuestBookBean>)request.getAttribute("list");
	%>
	<%=l.size()+"aaaa" %>
</body>
</html>