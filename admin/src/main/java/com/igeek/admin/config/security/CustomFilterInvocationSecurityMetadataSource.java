//package com.igeek.admin.config.security;
//
//import com.igeek.admin.model.entity.Permission;
//import com.igeek.admin.model.entity.RolePermissionRelation;
//import com.igeek.admin.service.base.UserPermissionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.access.SecurityConfig;
//import org.springframework.security.web.FilterInvocation;
//import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
//import org.springframework.stereotype.Component;
//import org.springframework.util.AntPathMatcher;
//
//import java.util.Collection;
//import java.util.List;
//
///**
// * @author zhouxu
// * @email 1419982188@qq.com
// * @date 2020/04/01
// */
//@Component
//public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
//    @Autowired
//    UserPermissionService userPermissionService;
//
//    AntPathMatcher antPathMatcher = new AntPathMatcher();
//
//    @Override
//    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
//        String requestUrl = ((FilterInvocation) object).getRequestUrl();
//        List<RolePermissionRelation> rolePermissionRelations = userPermissionService.getAllMenusWithRole();
//        for (RolePermissionRelation rolePermissionRelation : rolePermissionRelations) {
////            if (antPathMatcher.match(rolePermissionRelation.getUrl(), requestUrl)) {
////                List<Permission> roles = permission.getRoles();
////                String[] str = new String[roles.size()];
////                for (int i = 0; i < roles.size(); i++) {
////                    str[i] = roles.get(i).getName();
////                }
////                return SecurityConfig.createList(str);
////            }
//        }
//        return SecurityConfig.createList("ROLE_LOGIN");
//    }
//
//    @Override
//    public Collection<ConfigAttribute> getAllConfigAttributes() {
//        return null;
//    }
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return true;
//    }
//}
