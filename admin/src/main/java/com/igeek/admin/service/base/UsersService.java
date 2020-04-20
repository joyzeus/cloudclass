package com.igeek.admin.service.base;

import com.igeek.admin.model.entity.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author zhouxu
 * @date 2020/04/10
 * @email 1419982188@qq.com
 */
public interface UsersService extends UserDetailsService {
    /**
     * 查询账户
     *
     * @param account
     * @return
     */
    Users findUsers(String account);

    /**
     * 根据用户账号查询用户信息
     *
     * @param account 用户账号
     * @return 用户全部信息
     */
    Users selectByAccount(String account);

    Integer save(Users user);

    Users selectByUserId(Long userId);
}
