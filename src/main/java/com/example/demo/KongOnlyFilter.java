package com.example.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class KongOnlyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String fromKong = req.getHeader("X-From-Kong");
        if (!"true".equals(fromKong)) {
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, "Access denied");
            return;
        }
        chain.doFilter(request, response);
    }
}