package com.jay.book.admin.config.shiro;

import com.jay.book.admin.constant.RedisKeyEnum;
import com.jay.book.admin.config.redis.RedisUtil;
import com.jay.book.admin.service.base.UsersService;
import com.jay.book.admin.entity.Users;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * @author zhouxu
 * @date 2019/12/24
 */
@Component
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UsersService usersService;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof AuthToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Users users = (Users) principals.getPrimaryPrincipal();

        //用户权限列表
        Set<String> permsSet = new HashSet<String>();
        List<String> list = new ArrayList<String>();
        list.add("sys:menu:menuTree");
        list.add("sys:menu:getLeftMenuList");
        permsSet.addAll(list);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        AuthToken token = (AuthToken) authcToken;
        String key = RedisKeyEnum.USERID.getKey() + ":" + token;
        String userId = "";
        if (redisUtil.has(key)) {
            userId = redisUtil.get(key, String.class);
        } else {
            throw new RuntimeException("您的账号已经退出登录,请重新登录");
        }

        String userKey = RedisKeyEnum.TOKEN.getKey() + ":" + userId;
        if (redisUtil.has(userKey)) {
            String uId = redisUtil.get(userKey, String.class);
            if (StringUtils.isEmpty(uId)) {
                throw new RuntimeException("您的账号已经退出登录,请重新登录");
            }
        } else {
            throw new RuntimeException("您的账号已经退出登录,请重新登录");
        }

        Users user = usersService.selectByUserId(Integer.valueOf(userId));
        if (user == null) {
            throw new UnknownAccountException("账户不存在");
        }

        return new SimpleAuthenticationInfo(user, token, getName());
    }
}
