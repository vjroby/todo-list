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
                <h1 class="page-header">Create a new To Do list</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Create Form
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-8 col-lg-offset-2">
                                <form:form role="form" method="post" modelAttribute="todolist" enctype="utf8">
                                    form
                                    <div class="form-group">
                                        <label for="title">Title:</label>
                                        <form:input class="form-control" name="title" id="title" path="title" />

                                        <p class="help-block">The title of the to do list.</p>
                                        <form:errors path="title" cssStyle="color: #ff0000;"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="description">Description:</label>
                                        <form:textarea class="form-control" name="description" id="description" path="description"></form:textarea>
                                        <p class="help-block">The description of the to do list.</p>
                                        <form:errors path="description" cssStyle="color: #ff0000;"/>

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