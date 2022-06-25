<%@page import="yuhan.mvc.teamproject.dto.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>       
<style>
table {
    width: 100%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  td {
    border-bottom: 1px solid #444444;
  }
</style>
    </head>
    <body>
<table width="600" cellpadding="1" cellspacing="1" border="2">
<tr>
<td>번호</td>
<td>이름</td>
<td>제목</td>

</tr>
<c:forEach items="${HardWarelist}" var="dto" begin = "0" end = "9" step = "1">
<tr>
<td>${dto.h_no}</td>
<td>${dto.h_name}</td>
<td>
<a href="HardWarecontent_view?h_no=${dto.h_no}">${dto.h_subject}</a></td>
</tr>
</c:forEach>
</table>
</center>

</body>
</html>
