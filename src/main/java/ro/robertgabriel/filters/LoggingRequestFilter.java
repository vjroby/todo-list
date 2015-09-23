package ro.robertgabriel.filters;

import org.apache.commons.lang.time.StopWatch;
import ro.robertgabriel.dao.MongoDBAccessLogDao;
import ro.robertgabriel.model.AccessLogModel;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class LoggingRequestFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        StopWatch timer = new StopWatch();

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        AccessLogModel accessLogModel = new AccessLogModel();
        accessLogModel.setCreated(new Date());
        accessLogModel.setIp(resolveIp(req));
        accessLogModel.setUrlPath(req.getRequestURI());
        accessLogModel.setUserAgent(req.getHeader("User-Agent"));
        MongoDBAccessLogDao mongoDBAccessLogDao = new MongoDBAccessLogDao();

        try{
            timer.start();
            chain.doFilter(request, response);
        } finally {
            timer.stop();
            accessLogModel.setRequestTime(timer.toString());
            mongoDBAccessLogDao.createAccessLog(accessLogModel);

        }

    }

    @Override
    public void destroy() {

    }

    protected String resolveIp( HttpServletRequest request ) {
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }
}
