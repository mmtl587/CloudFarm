package com.example.CloudFarm.utility;

import com.auth0.jwt.interfaces.Claim;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;

@Slf4j
@WebFilter(filterName = "JwtFilter", urlPatterns = "/filter/*")
public class JwtFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;

        response.setCharacterEncoding("UTF-8");
        //获取 header里的token
        final String token = request.getHeader("authorization");

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(request, response);
        }
        // Except OPTIONS, other request should be checked by JWT
        else {

            if (token == null) {
                response.getWriter().write("没有token！");
                return;
            }

            Map<String, Claim> userData = JwtUtil.verifyToken(token);
            if (userData == null) {
                response.getWriter().write("token不合法！");
                return;
            }
            Integer id = userData.get("id").asInt();
            String userName = userData.get("userName").asString();
            String password = userData.get("password").asString();
            //拦截器 拿到用户信息，放到request中
            request.setAttribute("id", id);
            request.setAttribute("userName", userName);
            request.setAttribute("password", password);
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
    }
}
