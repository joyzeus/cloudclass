package com.jay.book.admin.service.base;

public interface UserTokenService {

    String createSaveToken(Integer userId);

    boolean logout(Integer userId);
}
