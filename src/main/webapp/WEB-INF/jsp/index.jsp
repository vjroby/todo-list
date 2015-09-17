<%@ page import="java.util.List" %>
<%@ page import="main.java.model.ListModel" %>
<%--@elvariable id="lists" type="java.util.List"--%>
<%
  List<ListModel> lists = (List)request.getAttribute("lists");
%>

<body>
<div class="col-md-12">
  <h2>Welcome!</h2>
  <p>If you want to go go to lists just follow the below links:</p>

  <a href="<c:url value="/services/lists" />" class="btn btn-default">See al the lists</a>
</div>
<div class="col-md-12">
  <%
    for (ListModel list : lists){
      out.print(list.getId());
      out.print("<br />");
    }
  %>
</div>
</body>
</html>
