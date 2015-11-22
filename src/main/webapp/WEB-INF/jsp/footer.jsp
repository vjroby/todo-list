<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ro.robertgabriel.frontend.FrontEndConfiguration" %>
<%--@elvariable id="lists" type="java.util.List"--%>
<%--@elvariable id="configuration" type="ro.robertgabriel.frontend.Configuration"--%>
<%
  FrontEndConfiguration frontEndConfiguration = (FrontEndConfiguration) request.getAttribute("configuration");
  String appName = frontEndConfiguration.getAppName();
  String subTitle = frontEndConfiguration.getAppSubtitle();
%>
<!-- Footer -->
<footer id="contact">
  <div class="container">
    <div class="row">
      <div class="col-lg-10 col-lg-offset-1 text-center">
        <h4><strong>Todo List Web App</strong>
        </h4>
        <p>Somewhere Over The Rainbow<br>City Of Angels</p>
        <ul class="list-unstyled">
          <li><i class="fa fa-phone fa-fw"></i> (123) 456-7890</li>
          <li><i class="fa fa-envelope-o fa-fw"></i>  <a href="mailto:name@example.com">name@example.com</a>
          </li>
        </ul>
        <br>
        <ul class="list-inline">
          <li>
            <a href="#"><i class="fa fa-facebook fa-fw fa-3x"></i></a>
          </li>
          <li>
            <a href="#"><i class="fa fa-twitter fa-fw fa-3x"></i></a>
          </li>
          <li>
            <a href="#"><i class="fa fa-dribbble fa-fw fa-3x"></i></a>
          </li>
        </ul>
        <hr class="small">
        <p class="text-muted"><%=appName%> 2015</p>
      </div>
    </div>
  </div>
</footer>
