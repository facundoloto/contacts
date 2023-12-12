package com.demo.contacts.Security.Jwt;

//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//@Component
//public class JwtFilter extends OncePerRequestFilter {
//    // Simple JWT implementation
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    public JwtFilter(String jwtSecret) {
//    }
//
//    // Spring Security will call this method during filter chain execution
//    @Override
//    protected void doFilterInternal(HttpServletRequest httpServletRequest,
//                                    HttpServletResponse httpServletResponse,
//                                    FilterChain filterChain) throws ServletException, IOException {
//
//        // trying to find Authorization header
//        final String authorizationHeader = httpServletRequest.getHeader("Authorization");
//        if (authorizationHeader == null || authorizationHeader.isEmpty() || !authorizationHeader.startsWith("Bearer")){
//            // if Authorization header does not exist, then skip this filter
//            // and continue to execute next filter class
//            filterChain.doFilter(httpServletRequest, httpServletResponse);
//            return;
//        }
//
//        final String token = authorizationHeader.split(" ")[1].trim();
//        if (!jwtUtil.validate(token)) {
//            // if token is not valid, then skip this filter
//            // and continue to execute next filter class.
//            // This means authentication is not successful since token is invalid.
//            filterChain.doFilter(httpServletRequest, httpServletResponse);
//            return;
//        }
//
//        // Authorization header exists, token is valid. So, we can authenticate.
//        String username = jwtUtil.getUsername(token);
//        // initializing UsernamePasswordAuthenticationToken with its 3 parameter constructor
//        // because it sets super.setAuthenticated(true); in that constructor.
//        UsernamePasswordAuthenticationToken upassToken = new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
////        upassToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
//        // finally, give the authentication token to Spring Security Context
//        SecurityContextHolder.getContext().setAuthentication(upassToken);
//
//        // end of the method, so go for next filter class
//        filterChain.doFilter(httpServletRequest, httpServletResponse);
//    }
//}

