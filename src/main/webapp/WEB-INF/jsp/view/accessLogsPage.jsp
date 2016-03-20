<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="access_logs" type="java.lang.Iterable<ro.robertgabriel.entities.AccessLogOld>"--%>
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
                <jsp:include page="modules\pagination.jsp"/>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Access Logs
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                <tr>
                                    <th>Ip</th>
                                    <th>created</th>
                                    <th>urlPath</th>
                                    <th>userAgent</th>
                                    <th>requestTime</th>
                                    <%--<th>Edit</th>--%>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${access_logs}" var="accessLog">
                                    <tr class="odd gradeX">
                                        <td>${accessLog.ip}</td>
                                        <td>${accessLog.created}</td>
                                        <td>${accessLog.urlPath}</td>
                                        <td>${accessLog.userAgent}</td>
                                        <td>${accessLog.requestTime}</td>
                                            <%--<td><a href="<c:url value="/todos/view/${accessLog.id}" /> " class="btn btn-primary">View</a></td>--%>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <jsp:include page="modules\pagination.jsp"/>
            </div>
        </div>
    </div>
</div>
</body>