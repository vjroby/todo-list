<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="todolists" type="java.lang.Iterable<ro.robertgabriel.entities.TodoList>"--%>
<jsp:include page="../base.jspf"/>
</head>
<body>
<div id="wrapper">
    <jsp:include page="modules\navigationDashboard.jsp"/>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Todo Lists</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        DataTables Advanced Tables
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                <tr>
                                    <th>Title</th>
                                    <th>Description</th>
                                    <th>User</th>
                                    <th>Created</th>
                                    <th>Updated</th>
                                    <th>Edit</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${todolists}" var="todolist">
                                    <tr class="odd gradeX">
                                        <td>${todolist.title}</td>
                                        <td>${todolist.description}</td>
                                        <td>${todolist.user.firstName}&NonBreakingSpace; ${todolist.user.lastName}</td>
                                        <td>${todolist.created}</td>
                                        <td>${todolist.updated}</td>
                                        <td><a href="<c:url value="/todos/view/${todolist.id}" /> " class="btn btn-primary">View</a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>