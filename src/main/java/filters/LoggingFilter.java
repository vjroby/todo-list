package main.java.filters;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

public class LoggingFilter extends com.sun.jersey.api.container.filter.LoggingFilter implements ContainerResponseFilter{

    private static final ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    public static boolean vorboseLogging = false;

    @Override
    public ContainerRequest filter(ContainerRequest arg0) {
        startTime.set(System.currentTimeMillis());
        String ip = arg0.getHeaderValue("X-Forwarded-For");
        System.out.println("IP reqest: " + ip);
        return arg0;
    }
    @Override
    public ContainerResponse filter(ContainerRequest request, ContainerResponse response){
        System.out.println(System.currentTimeMillis() - startTime.get());
        StringBuilder sb = new StringBuilder();
        sb.append("User:").append((request.getUserPrincipal() == null ? "unknown" : request.getUserPrincipal().getName()));
        sb.append(" - Path:").append(request.getRequestUri().getPath());
        System.out.println(sb);
        return response;
    }
}
