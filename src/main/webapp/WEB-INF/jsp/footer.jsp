<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ro.robertgabriel.frontend.Configuration" %>
<%--@elvariable id="lists" type="java.util.List"--%>
<%--@elvariable id="configuration" type="ro.robertgabriel.frontend.Configuration"--%>
<%
  Configuration configuration = (Configuration)request.getAttribute("configuration");
  String appName = configuration.getAppName();
  String subTitle = configuration.getAppSubtitle();
%>
<!-- Footer -->
<footer id="contact">
  <div class="container">
    <div class="row">
      <div class="col-lg-10 col-lg-offset-1 text-center">
        <h4><strong>Start Bootstrap</strong>
        </h4>
        <p>3481 Melrose Place<br>Beverly Hills, CA 90210</p>
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
        <p class="text-muted"><%=appName%> 2014</p>
      </div>
    </div>
  </div>
</footer>
