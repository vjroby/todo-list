<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="ro.robertgabriel.model.ListModel" %>
<%@ page import="ro.robertgabriel.frontend.FrontEndConfiguration" %>
<%@ page import="ro.robertgabriel.frontend.MenuItem" %>
<%--@elvariable id="lists" type="java.util.List"--%>
<%--@elvariable id="configuration" type="ro.robertgabriel.frontend.Configuration"--%>
<%
    List lists = (List)request.getAttribute("lists");
    FrontEndConfiguration frontEndConfiguration = (FrontEndConfiguration) request.getAttribute("configuration");
    String appName = frontEndConfiguration.getAppName();
    String subTitle = frontEndConfiguration.getAppSubtitle();
%>

<body>

<!-- Navigation -->
<a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i class="fa fa-bars"></i></a>
<nav id="sidebar-wrapper">
    <ul class="sidebar-nav">
        <a id="menu-close" href="#" class="btn btn-light btn-lg pull-right toggle"><i class="fa fa-times"></i></a>
        <li class="sidebar-brand">
            <a href="#top"  onclick = $("#menu-close").click(); ><%=appName%></a>
        </li>
        <c:forEach items="${configuration.getMenuItems()}" var="menuItem">
            <li>
                <a href="${menuItem.getUrl()}" onclick = $("#menu-close").click(); >${menuItem.getName()}</a>
            </li>
        </c:forEach>
    </ul>
</nav>

<!-- Header -->
<header id="top" class="header">
    <div class="text-vertical-center">
        <h1><%=appName%></h1>
        <h3><%=subTitle%></h3>
        <br>
        <a href="#about" class="btn btn-dark btn-lg">Find Out More</a>
    </div>
</header>

<!-- About -->
<section id="about" class="about">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2>Let us help you not forget to do things anymore!</h2>
                <p class="lead">You can explore the rich features of the application before making an <a href="signup">account.</a></p>
            </div>
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container -->
</section>

<!-- Services -->
<!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
<section id="services" class="services bg-primary">
    <div class="container">
        <div class="row text-center">
            <div class="col-lg-10 col-lg-offset-1">
                <h2>Application Features</h2>
                <hr class="small">
                <div class="row">
                    <div class="col-md-3 col-sm-6">
                        <div class="service-item">
                                <span class="fa-stack fa-4x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-cloud fa-stack-1x text-primary"></i>
                            </span>
                            <h4>
                                <strong>Security</strong>
                            </h4>
                            <p>Using Spring Security</p>
                            <a href="#" class="btn btn-light">Learn More</a>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6">
                        <div class="service-item">
                                <span class="fa-stack fa-4x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-compass fa-stack-1x text-primary"></i>
                            </span>
                            <h4>
                                <strong>NoSQL</strong>
                            </h4>
                            <p>For data persistance we use MongoDB</p>
                            <a href="#" class="btn btn-light">Learn More</a>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6">
                        <div class="service-item">
                                <span class="fa-stack fa-4x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-flask fa-stack-1x text-primary"></i>
                            </span>
                            <h4>
                                <strong>Java Spring Framework</strong>
                            </h4>
                            <p>For our backend we are using the Spring MVC Framework version 4.1.6</p>
                            <a href="#" class="btn btn-light">Learn More</a>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6">
                        <div class="service-item">
                                <span class="fa-stack fa-4x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-shield fa-stack-1x text-primary"></i>
                            </span>
                            <h4>
                                <strong>Openshift</strong>
                            </h4>
                            <p>For deployment we are using JBoss</p>
                            <a href="#" class="btn btn-light">Learn More</a>
                        </div>
                    </div>
                </div>
                <!-- /.row (nested) -->
            </div>
            <!-- /.col-lg-10 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container -->
</section>

<!-- Callout -->
<aside class="callout">
    <div class="text-vertical-center">
        <h1>Start Planning</h1>
    </div>
</aside>

<!-- Portfolio -->
<section id="ideas" class="portfolio">
    <div class="container">
        <div class="row">
            <div class="col-lg-10 col-lg-offset-1 text-center">
                <h2>Keep track of your ideas...</h2>
                <hr class="small">
                <div class="row">
                    <div class="col-md-6">
                        <div class="portfolio-item">
                            <a href="#">
                                <img class="img-portfolio img-responsive" src="resources/img/portfolio-1.jpg">
                            </a>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="portfolio-item">
                            <a href="#">
                                <img class="img-portfolio img-responsive" src="resources/img/portfolio-2.jpg">
                            </a>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="portfolio-item">
                            <a href="#">
                                <img class="img-portfolio img-responsive" src="resources/img/portfolio-3.jpg">
                            </a>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="portfolio-item">
                            <a href="#">
                                <img class="img-portfolio img-responsive" src="resources/img/portfolio-4.jpg">
                            </a>
                        </div>
                    </div>
                </div>
                <!-- /.row (nested) -->
                <a href="#" class="btn btn-dark">View More Items</a>
            </div>
            <!-- /.col-lg-10 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /.container -->
</section>

<!-- Call to Action -->
<aside class="call-to-action bg-primary">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h3>Make an account or Login</h3>
                <a href="/signup" class="btn btn-lg btn-light">Sign Up</a>
                <a href="/login" class="btn btn-lg btn-dark">Log In!</a>
            </div>
        </div>
    </div>
</aside>

<!-- Map -->
<%--<section id="contact" class="map">--%>
    <%--<iframe width="100%" height="100%" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;aq=0&amp;oq=twitter&amp;sll=28.659344,-81.187888&amp;sspn=0.128789,0.264187&amp;ie=UTF8&amp;hq=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;t=m&amp;z=15&amp;iwloc=A&amp;output=embed"></iframe>--%>
    <%--<br />--%>
    <%--<small>--%>
        <%--<a href="https://maps.google.com/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;aq=0&amp;oq=twitter&amp;sll=28.659344,-81.187888&amp;sspn=0.128789,0.264187&amp;ie=UTF8&amp;hq=Twitter,+Inc.,+Market+Street,+San+Francisco,+CA&amp;t=m&amp;z=15&amp;iwloc=A"></a>--%>
    <%--</small>--%>
    <%--</iframe>--%>
<%--</section>--%>

<jsp:include page="footer.jsp" />

<!-- jQuery -->
<script src="resources/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="resources/js/bootstrap.min.js"></script>

<!-- Custom Theme JavaScript -->
<script>
    // Closes the sidebar menu
    $("#menu-close").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });

    // Opens the sidebar menu
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });

    // Scrolls to the selected menu item on the page
    $(function() {
        $('a[href*=#]:not([href=#])').click(function() {
            if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {

                var target = $(this.hash);
                target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                if (target.length) {
                    $('html,body').animate({
                        scrollTop: target.offset().top
                    }, 1000);
                    return false;
                }
            }
        });
    });
</script>

</body>
<%--<body>--%>
<%--<div class="col-md-12">--%>
  <%--<h2>Welcome!</h2>--%>
  <%--<p>If you want to go go to lists just follow the below links:</p>--%>

  <%--<a href="<c:url value="/services/lists" />" class="btn btn-default" style="margin-bottom: 10px">See al the lists</a>--%>
<%--</div>--%>
<%--<div class="col-md-12" >--%>
<%--<c:forEach items="${lists}" var="list">--%>
 <%--<a href="<c:url value="/services/lists/${list.getId()}" />" class="btn btn-info" >${list.getTitle()}</a>--%>
 <%--<a href="<c:url value="/services/lists/${list.getId()}" />/items/" class="btn btn-info" >${list.getTitle()} with items</a>--%>
<%--</c:forEach>--%>
<%--</div>--%>
<%--</body>--%>


</html>
