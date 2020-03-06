package com.jay.book.admin.controller;

import com.jay.book.admin.entity.LoginLog;
import com.jay.book.admin.entity.Users;
import com.jay.book.admin.entity.bo.UserLoginBO;
import com.jay.book.admin.entity.vo.UsersVo;
import com.jay.book.admin.service.base.SysLogService;
import com.jay.book.admin.service.base.UserTokenService;
import com.jay.book.admin.service.base.UsersService;
import com.jay.book.admin.service.base.VerificationCodeService;
import com.jay.book.admin.util.IPUtil;
import com.jay.book.admin.util.MD5Util;
import com.jay.book.admin.util.R;
import com.jay.book.admin.util.UserAgentUtils;
import com.jay.book.common.api.ResultCode;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
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
import java.util.Date;

/**
 * @author zhouxu
 * @date 2019/12/24
 */
@RestController
@RequestMapping("/user")
public class LoginController extends BaseContorller {

    private final UsersService userService;

    private final UserTokenService userTokenService;

    private final VerificationCodeService verificationCodeService;

    private final SysLogService sysLogService;


    @Autowired(required = false)
    public LoginController(UsersService userService, UserTokenService userTokenService,
                           VerificationCodeService verificationCodeService, SysLogService sysLogService) {
        this.userService = userService;
        this.userTokenService = userTokenService;
        this.verificationCodeService = verificationCodeService;
        this.sysLogService = sysLogService;
    }

    @GetMapping("/register")
    public Object register(@RequestParam String mobile, @RequestParam String password) {
        Users user = new Users();
        user.setMobile(mobile);
        user.setPassword(password);
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
    public UsersVo login(@RequestBody UserLoginBO userLoginBO, HttpServletRequest request) {
        long startTime = System.nanoTime();
        UsersVo usersVo = new UsersVo();
        //1.验证验证码是否有效
//        String uuid = userLoginBO.getUuid();
//        Integer code = verificationCodeService.authVerificationCode(uuid, userLoginBO.getVerificationCode());
//        if (code == 1) {
//            usersVo.setCode(ResultCode.FAILED.getCode());
//            resultWithLog(request, usersVo, "验证码不正确", startTime);
//            return usersVo;
//        } else if (code == 2) {
//            usersVo.setCode(ResultCode.FAILED.getCode());
//            resultWithLog(request, usersVo, "验证码错误", startTime);
//            return usersVo;
//        }

        String account = userLoginBO.getUsername();
        if (StringUtils.isEmpty(account)) {
            usersVo.setCode(ResultCode.FAILED.getCode());
            resultWithLog(request, usersVo, "账号未填写", startTime);
            return usersVo;
        }

        String loginBOPassword = userLoginBO.getPassword();
        if (StringUtils.isEmpty(loginBOPassword)) {
            usersVo.setCode(ResultCode.FAILED.getCode());
            resultWithLog(request, usersVo, "密码未填写", startTime);
            return usersVo;
        }

        //2.查询用户是否存在
        Users user = userService.selectByAccount(account);
        if (user == null) {
            usersVo.setCode(ResultCode.FAILED.getCode());
            usersVo.setAccout(account);
            resultWithLog(request, usersVo, "账号不存在", startTime);
            return usersVo;
        }

        usersVo.setAccout(user.getAccount());
        usersVo.setUserId(user.getUserId());
        //3.判断用户密码是否正确
        String password = user.getPassword();
        if (StringUtils.equals(MD5Util.encode(loginBOPassword), password)) {
            //4.生成token 并保存token 返回给用户
            String token = userTokenService.createSaveToken(user.getUserId());

            //5.保存用户登录日志信息
            usersVo.setToken(token);
            usersVo.setCode(ResultCode.SUCCESS.getCode());
            resultWithLog(request, usersVo, "登录成功", startTime);
            return usersVo;
        } else {
            usersVo.setCode(ResultCode.FAILED.getCode());
            resultWithLog(request, usersVo, "密码错误", startTime);
            return usersVo;
        }
    }

    public void resultWithLog(HttpServletRequest request, UsersVo usersVo, String message, Long startTime) {
        usersVo.setMessage(message);
        String ipAddr = IPUtil.getIpAddr(request);
        String ipLocation = IPUtil.getIPLocation(ipAddr);
        UserAgent userAgent = UserAgentUtils.getUserAgent(request);
        Version browserVersion = userAgent.getBrowserVersion();

        LoginLog loginLog = LoginLog.Builder.aLoginLog()
                .withCreateTime(new Date())
                .withLoginSuccess(Integer.valueOf(usersVo.getCode().toString()))
                .withIp(ipAddr)
                .withLocation(ipLocation)
                .withDeviceType(userAgent.getOperatingSystem().getName())
                .withKarnelVersion(browserVersion == null ? "" : browserVersion.getVersion())
                .withAgentType(userAgent.getBrowser().getName())
                .withUseragent(request.getHeader("User-Agent"))
                .withMessage(message)
                .build();
        loginLog.setSpendTime(System.nanoTime() - startTime);
        loginLog.setUserId(usersVo.getUserId());
        loginLog.setAccount(usersVo.getAccout());
        sysLogService.insertLog(loginLog);
    }
}

