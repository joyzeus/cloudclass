package com.igeek.admin.service.base;

public interface UserTokenService {

    String createSaveToken(Integer userId);

    boolean logout(Integer userId);
}
