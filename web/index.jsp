<%-- 
    Document   : index.jsp
    Created on : Mar 13, 2015, 9:18:53 AM
    Author     : Jonathan
    Version    : 0.1.0
    Since      : 0.1.0
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Locale" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    pageContext.setAttribute("requestLocale", request.getLocale());
%>

<fmt:setLocale value="${requestLocale}" />
<fmt:setBundle basename="messages" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="${requestLocale.language}" xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="jsp.index.title" /></title>
    </head>
    <body>
        <h2><fmt:message key="jsp.index.title" /></h2>
        <p><fmt:message key="jsp.index.hello" /><c:out value=" "></c:out><a href="test.do"><fmt:message key="jsp.index.here" /></a><c:out value=" "></c:out><fmt:message key="jsp.index.run" /></p>
    </body>
</html>
