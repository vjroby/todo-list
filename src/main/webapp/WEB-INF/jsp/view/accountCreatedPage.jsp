<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../base.jspf" />
</head>
<body
<%@ page session="true" %>
<fmt:setBundle basename="messages"/>
<fmt:message key="message.password" var="noPass"/>
<fmt:message key="message.username" var="noUser"/>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Try new account!</h3>
                </div>

                <div class="panel-body">

                   <span>Account created!</span>
                    <a href="<c:url value="/login" /> " class="btn btn-success">Go to login in!</a>

                </div>
            </div>
        </div>
    </div>
</div>
