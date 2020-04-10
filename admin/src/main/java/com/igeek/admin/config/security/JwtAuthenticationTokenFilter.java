package com.igeek.admin.config.security;

import com.igeek.admin.config.jwt.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * token校验,引用的stackoverflow一个答案里的处理方式
 *
 * @author : zhouxu
 * @date : 2018/9/14
 * @email 1419982188@qq.com
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {


    @Resource
    private JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        String authToken = request.getHeader(this.tokenHeader);
        if (StringUtils.isNotEmpty(authToken) && authToken.startsWith(jwtUtils.tokenHead)) {
            authToken = authToken.substring(jwtUtils.tokenHead.length());
        } else {
            authToken = null;
        }

        String username = jwtUtils.getUsernameFromToken(authToken);

        logger.info(String.format("Checking authentication for user %s.", username));

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails user = jwtUtils.getUserFromToken(authToken);
            if (jwtUtils.validateToken(authToken, user)) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                logger.info(String.format("Authenticated user %s, setting security context", username));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(request, response);
    }
}