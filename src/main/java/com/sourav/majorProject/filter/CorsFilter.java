package com.sourav.majorProject.filter;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response1= (HttpServletResponse) res;
        HttpServletRequest request1= (HttpServletRequest) req;
        response1.setHeader("Access-Control-Allow-Origin","*");
        response1.setHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS,DELETE,PUT");
        response1.setHeader("Access-Control-Max-Age","3600");
        response1.setHeader("Access-Control-Allow-Headers","x-requested-with,authorization,content-type");
        if ("OPTIONS".equalsIgnoreCase(request1.getMethod())){
            response1.setStatus(200);
        }else {
            chain.doFilter(req,res);
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
