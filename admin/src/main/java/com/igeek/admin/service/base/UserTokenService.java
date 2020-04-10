package com.igeek.admin.service.base;

public interface UserTokenService {

    String createSaveToken(Long userId);

    boolean logout(Integer userId);
}
