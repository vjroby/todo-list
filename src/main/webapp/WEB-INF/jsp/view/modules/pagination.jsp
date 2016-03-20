<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
    <ul class="pager">
        <%--@elvariable id="hasPrevious" type="boolean"--%>
        <c:if test="${hasPrevious}">
            <li class="previous">
                <a href="<c:url value="/admin/access_logs?page=${currentPage-1}"/>" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>
            <li class="disabled" ><a href="#">Total Items: ${totalItems}</a></li>

        <c:if test="${hasNext}">

            <li class="next">
                <a href="<c:url value="/admin/access_logs?page=${currentPage+1}"/>" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
    </ul>
</nav>