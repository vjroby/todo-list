<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../base.jspf"/>
</head>
<body>
<div id="wrapper">
    <jsp:include page="modules\navigationDashboard.jsp"/>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">User Details</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Modify your details
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-8 col-lg-offset-2">
                                <form:form role="form" method="post" modelAttribute="user" enctype="utf8">
                                    <form:hidden path="id" />
                                    <div class="form-group">
                                        <label for="firstName">First Name:</label>
                                        <form:input class="form-control" name="firstName" id="firstName" path="firstName" />

                                        <p class="help-block">Your first name.</p>
                                        <form:errors path="firstName" cssStyle="color: #ff0000;"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="lastName">Last Name.</label>
                                        <form:input class="form-control" name="lastName" id="lastName" path="lastName" />
                                        <p class="help-block">Your last name.</p>
                                        <form:errors path="lastName" cssStyle="color: #ff0000;"/>

                                    </div>
                                    <button type="submit" class="btn btn-primary">Save</button>
                                    <button type="reset" class="btn btn-warning">Reset Form</button>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>