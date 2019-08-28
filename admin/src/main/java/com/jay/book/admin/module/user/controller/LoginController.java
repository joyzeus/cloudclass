package com.jay.book.admin.module.user.controller;

import com.jay.book.admin.module.user.entity.po.Users;
import com.jay.book.admin.config.shiro.PasswordHelper;
import com.jay.book.admin.module.user.entity.bo.UserLoginBO;
import com.jay.book.admin.module.user.service.base.SysLogService;
import com.jay.book.admin.module.user.service.base.UserService;
import com.jay.book.admin.module.user.service.base.UserTokenService;
import com.jay.book.admin.module.user.service.base.VerificationCodeService;
import com.jay.book.admin.util.MD5Util;
import com.jay.book.admin.util.R;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("/user")
public class LoginController extends BaseContorller {

    private final UserService userService;

    private final UserTokenService userTokenService;

    private final VerificationCodeService verificationCodeService;

    private final PasswordHelper passwordHelper;

    private final SysLogService sysLogService;


    @Autowired(required = false)
    public LoginController(UserService userService, UserTokenService userTokenService,
                           VerificationCodeService verificationCodeService, PasswordHelper passwordHelper, SysLogService sysLogService) {
        this.userService = userService;
        this.userTokenService = userTokenService;
        this.verificationCodeService = verificationCodeService;
        this.passwordHelper = passwordHelper;
        this.sysLogService = sysLogService;
    }

    @GetMapping("/register")
    public Object register(@RequestParam String mobile, @RequestParam String password) {
        Users user = new Users();
        user.setMobile(mobile);
        user.setPassword(password);
        passwordHelper.encryptPassword(user);
        return R.ok().put("count", userService.save(user));
    }

    @GetMapping("/captcha.jpg")
    public void captcha(@RequestParam String uuid, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        BufferedImage bufferedImage = verificationCodeService.creaeteImgge(uuid);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bufferedImage, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    @PostMapping("/login")
    public R login(@RequestBody UserLoginBO userLoginBO, HttpServletRequest request) {
        //1.验证验证码是否有效
        String uuid = userLoginBO.getUuid();
        Integer code = verificationCodeService.authVerificationCode(uuid, userLoginBO.getVerificationCode());
        if (code == 1) {
            return R.error("验证码不存在或者已过期");
        } else if (code == 2) {
            return R.error("验证码错误");
        }

        String account = userLoginBO.getAccount();
        if (StringUtils.isEmpty(account)) {
            return R.error("账号未填写");
        }

        String loginBOPassword = userLoginBO.getPassword();
        if (StringUtils.isEmpty(loginBOPassword)) {
            return R.error("密码未填写");
        }

        //2.查询用户是否存在
        Users user = userService.selectByAccount(account);
        if (user == null) {
            return R.error("账号不存在");
        }

        //3.判断用户密码是否正确
        String password = user.getPassword();
        if (StringUtils.equals(MD5Util.encode(loginBOPassword), password)) {
            //4.生成token 并保存token 返回给用户
            String token = userTokenService.createSaveToken(user.getUserId());

            //5.保存用户登录日志信息
            sysLogService.insertLog(request, user, user.getAccount() + "登录成功");
            return R.ok().put("token", token);
        } else {
            return R.error("密码错误");
        }
    }

    @GetMapping("/test")
    public R register() {
        int i = 3 / 0;
        return R.ok();
    }
}

