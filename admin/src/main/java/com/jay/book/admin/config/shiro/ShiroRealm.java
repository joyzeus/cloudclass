package com.jay.book.admin.config.shiro;

import com.jay.book.admin.constant.RedisKeyEnum;
import com.jay.book.admin.module.user.entity.po.Users;
import com.jay.book.admin.config.redis.RedisUtil;
import com.jay.book.admin.module.user.service.base.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof AuthToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
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


        Users user = userService.selectByUserId(Integer.valueOf(userId));
        if (user == null) {
            throw new UnknownAccountException("账户不存在");
        }

        return new SimpleAuthenticationInfo(user, token, getName());
    }
}
