<%--
  Created by IntelliJ IDEA.
  User: ZQ
  Date: 2021/1/21
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结果</title>
</head>
<body>
    <%
        Long sum = (Long) request.getAttribute("sum");
        Long mult = (Long) request.getAttribute("multiplication");
    %>
    <script>
        if (window.location.href.includes("add",16)){
            alert("a+b的值为" + <%=sum%>)
        }
        if (window.location.href.includes("mult",16)){
            alert("a*b的值为" + <%=mult%>)
        }
    </script>
</body>
</html>
