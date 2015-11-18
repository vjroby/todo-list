<div class="container">
    <div class="col-md-4 col-md-offset-4">
        <div class="panel pane-success">
            <div class="panel-heading">
                <span>Login successful!</span>
            </div>
            <body>
            <div class="col-md-12">
                <h2>Welcome!</h2>

                <p>If you want to go go to lists just follow the below links:</p>

                <a href="<c:url value="/services/lists" />" class="btn btn-default" style="margin-bottom: 10px">See al
                    the lists</a>
            </div>
            <div class="col-md-12">
                <c:forEach items="${lists}" var="list">
                    <a href="<c:url value="/services/lists/${list.getId()}" />"
                       class="btn btn-info">${list.getTitle()}</a>
                    <a href="<c:url value="/services/lists/${list.getId()}" />/items/"
                       class="btn btn-info">${list.getTitle()} with items</a>
                </c:forEach>
            </div>
            </body>
        </div>
    </div>
</div>