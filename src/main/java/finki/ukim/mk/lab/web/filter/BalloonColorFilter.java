package finki.ukim.mk.lab.web.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter
public class BalloonColorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String balloonColor = (String) request.getSession().getAttribute("balloonColor");

        String path = request.getServletPath();

        List<String> paths = List.of(
            "/balloons", "/selectBalloon", "/orders", "/balloons/add-form", "/balloons/add", "balloons/edit-form", "balloons/delete"
        );

        if ("".equals(path)){
            response.sendRedirect("/balloons");
        }
        else if (paths.stream().noneMatch(path::startsWith) && balloonColor == null) {
            response.sendRedirect("/balloons");
        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
