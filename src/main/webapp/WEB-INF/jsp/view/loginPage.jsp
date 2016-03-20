w<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                    <h3 class="panel-title">Log In.</h3>
                </div>

                <div class="panel-body">

                    <form role="form" method="post">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="E-mail" name="username" type="email" autofocus
                                       required>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" name="password" type="password"
                                       value="" required>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                </label>
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <input type="submit" class="btn btn-lg btn-success btn-block" value="Login"/>
                            <a href="/signup" class="btn btn-block btn-primary">Sign Up</a>
                            <a href="#" id="test-user" class="btn btn-block btn-info">Try the test user!</a>
                        </fieldset>
                    </form>

                    <c:if test="${param.logout != null}">
                        <div class="alert alert-danger">
                            <span class="alert">You have been logged out</span>
                        </div>
                    </c:if>
                    <c:if test="${param.error != null}">
                        <div class="alert alert-danger">
                            <span class="alert alert-error">There was an error, please try again</span>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $("#test-user").on('click',function(e){
        e.preventDefault();

        $("input[name='username']").val('test@todo.com');
        $("input[name='password']").val('test');
    });
    $(document).ready(function () {
        $("input[name='username'], input[name='password']").on('change', function () {
            $('div.alert').remove();
        });
        $("#test-user").on('click',function(e){
            e.preventDefault();

            $("input[name='username']").val('test@todo.com');
            $("input[name='password']").val('test');
        });
    });
</script>