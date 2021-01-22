<%--
  Created by IntelliJ IDEA.
  User: ZQ
  Date: 2021/1/21
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        String error = (String) request.getAttribute("error");
    %>

    <form id="param" method="get" onsubmit="myFunction()">
        <input name="a" type="text"><br>
        <input name="b" type="text"><br>
        <input id="add" type="checkbox"><span>相加</span>
        <input id="mult" type="checkbox"><span>相乘</span><br>
        <input type="submit" value="提交">
    </form>

    <script>
        var param = document.getElementById("param");
        var a = document.getElementsByName("a");
        var b = document.getElementsByName("b");
        var add = document.getElementById("add");
        var mult = document.getElementById("mult");


        if (<%=error%> != null){
            alert(<%=error%>)
        }

        function myFunction(){
            if (!add.checked && !mult.checked){
                alert("请选择相加或者相乘")
            }
            if (add.checked){
                param.action = "/add";
            }
            if (mult.checked){
                param.action = "/mult";
            }
        }
    </script>

</body>
</html>
