<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../base.jspf"/>
</head>
<body>
<div id="wrapper">
    <jsp:include page="modules\navigationDashboard.jsp"/>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Page not found!</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="row">
            <a href="<c:url value="/dashboard" />" class="btn btn-default" style="margin-bottom: 10px">Go to dashboard</a>
        </div>
    </div>
</div>
</body>
