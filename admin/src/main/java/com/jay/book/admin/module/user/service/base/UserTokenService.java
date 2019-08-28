package com.jay.book.admin.module.user.service.base;

public interface UserTokenService {

    String createSaveToken(Integer userId);

    boolean logout(Integer userId);
}
