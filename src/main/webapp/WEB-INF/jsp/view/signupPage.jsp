<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false"%>
<div class="container">
  <div class="row">
    <div class="col-md-4 col-md-offset-4">
      <div class="login-panel panel panel-default">
        <div class="panel-heading">
          <H1>
            <%--<spring:message code="label.form.title"></spring:message>--%>
          </H1>
          <h3 class="panel-title">Sign Up</h3>
        </div>
        <div class="panel-body">
          <form:form role="form" method="post" modelAttribute="user" enctype="utf8">
            <fieldset>
              <div class="form-group">
                <form:input class="form-control" placeholder="E-mail" name="email" type="email" autofocus="autofocus"  path="email"  />
              </div>
              <div class="form-group">
                <form:input class="form-control" placeholder="Password" name="password" type="password" value="" path="password" />
              </div>
              <div class="form-group">
                <form:input class="form-control" placeholder="First name" name="firstName" type="text" value="" path="firstName"  />
              </div>
              <div class="form-group">
                <form:input class="form-control" placeholder="Last Name" name="lastName" type="text" value="" path="lastName"  />
              </div>

              <!-- Change this to a button or input when using this as a form -->
              <input type="submit" value="SignUp" class="btn btn-primary btn-block"/>
              <a href="<c:url value="/login" />" class="btn btn-info btn-block">
                Login
              </a>
            </fieldset>
          </form:form>
        </div>
      </div>
    </div>
  </div>
</div>