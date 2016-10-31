<%@ page isErrorPage="true" import="java.io.*" contentType="text/plain"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

Message:
<%=exception.getMessage()%>

StackTrace:
<%
	StringWriter stringWriter = new StringWriter();
	PrintWriter printWriter = new PrintWriter(stringWriter);
	exception.printStackTrace(printWriter);
	out.println(stringWriter);
	printWriter.close();
	stringWriter.close();
%>
<br><br><br>
<a href="<c:url value='index.jsp' />">Return to INDEX</a>