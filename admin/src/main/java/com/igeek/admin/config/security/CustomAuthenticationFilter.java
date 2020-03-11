//package com.jay.book.admin.config.security;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.jay.book.admin.entity.bo.UserLoginBO;
//import org.springframework.http.MediaType;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.InputStream;
//
///**
// * @author zhouxu
// * @version v1.0
// * @email 1419982188@qq.com
// * @date 2019/12/24 21:27
// */
//
//public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        //attempt Authentication when Content-Type is json
//        if (request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE)
//                || request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
//
//            //use jackson to deserialize json
//            ObjectMapper mapper = new ObjectMapper();
//            UsernamePasswordAuthenticationToken authRequest = null;
//            try (InputStream is = request.getInputStream()) {
//                UserLoginBO userLoginBO = mapper.readValue(is, UserLoginBO.class);
//                authRequest = new UsernamePasswordAuthenticationToken(userLoginBO.getUsername(), userLoginBO.getPassword());
//            } catch (IOException e) {
//                e.printStackTrace();
//                authRequest = new UsernamePasswordAuthenticationToken("", "");
//            }
//            setDetails(request, authRequest);
//            return this.getAuthenticationManager().authenticate(authRequest);
//        } else {
//            return super.attemptAuthentication(request, response);
//        }
//    }
//}