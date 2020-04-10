package com.igeek.admin.controller;

import com.igeek.admin.model.entity.LoginLog;
import com.igeek.admin.model.entity.Users;
import com.igeek.admin.model.entity.bo.UserLoginBO;
import com.igeek.admin.model.vo.UsersVo;
import com.igeek.admin.service.base.SysLogService;
import com.igeek.admin.service.base.UserTokenService;
import com.igeek.admin.service.base.UsersService;
import com.igeek.admin.service.base.VerificationCodeService;
import com.igeek.common.api.ResultCode;
import com.igeek.common.util.*;
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
 * @email 1419982188@qq.com
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
        Users user = Users.builder().build();
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
            usersVo.setMessage("账号未填写");
            resultWithLog(request, usersVo, 0L, JacksonUtil.toJson(userLoginBO), startTime);
            return usersVo;
        }

        String loginPassword = userLoginBO.getPassword();
        if (StringUtils.isEmpty(loginPassword)) {
            usersVo.setCode(ResultCode.FAILED.getCode());
            usersVo.setMessage("密码未填写");
            resultWithLog(request, usersVo, 0L, JacksonUtil.toJson(userLoginBO), startTime);
            return usersVo;
        }

        //2.查询用户是否存在
        Users users = userService.findUsers(account);
        if (users == null) {
            usersVo.setCode(ResultCode.FAILED.getCode());
            usersVo.setAccout(account);
            usersVo.setMessage("账号或者密码错误");
            resultWithLog(request, usersVo, users.getId(), JacksonUtil.toJson(userLoginBO), startTime);
            return usersVo;
        }

        usersVo.setAccout(users.getAccount());
        //3.判断用户密码是否正确
        String password = users.getPassword();
        if (StringUtils.equals(MD5Util.encode(loginPassword), password)) {
            //4.生成token 并保存token 返回给用户
            String token = userTokenService.createSaveToken(users.getId());

            //5.保存用户登录日志信息
            usersVo.setToken(token);
            usersVo.setCode(ResultCode.SUCCESS.getCode());
            usersVo.setMessage("登录成功");
            resultWithLog(request, usersVo, users.getId(), JacksonUtil.toJson(userLoginBO), startTime);
            return usersVo;
        } else {
            usersVo.setCode(ResultCode.FAILED.getCode());
            usersVo.setMessage("账号或者密码错误");
            resultWithLog(request, usersVo, users.getId(), JacksonUtil.toJson(userLoginBO), startTime);
            return usersVo;
        }
    }

    public void resultWithLog(HttpServletRequest request, UsersVo usersVo, Long userId, String requestParams, Long startTime) {
        String ipAddr = IPUtil.getIpAddr(request);
        String ipLocation = IPUtil.getIPLocation(ipAddr);
        UserAgent userAgent = UserAgentUtils.getUserAgent(request);
        Version browserVersion = userAgent.getBrowserVersion();

        LoginLog loginLog = LoginLog.builder()
                .requestParams(requestParams)
                .createTime(new Date())
                .loginSuccess(Integer.valueOf(usersVo.getCode().toString()))
                .ip(ipAddr)
                .location(ipLocation)
                .deviceType(userAgent.getOperatingSystem().getName())
                .karnelVersion(browserVersion == null ? "" : browserVersion.getVersion())
                .agentType(userAgent.getBrowser().getName())
                .useragent(request.getHeader("User-Agent"))
                .message(usersVo.getMessage())
                .spendTime(System.nanoTime() - startTime)
                .userId(userId)
                .account(usersVo.getAccout())
                .build();
        sysLogService.insertLog(loginLog);
    }
}

