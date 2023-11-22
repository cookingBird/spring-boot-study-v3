package com.example.demo.modules.user.controller;

import com.example.demo.common.factory.Response;
import com.example.demo.modules.user.domain.UserEntity;
import com.example.demo.modules.user.service.IUserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@Api(value = "用户授权认证")
@RequestMapping("/user")
@RestController
@AllArgsConstructor
public class UserController {


    private IUserService userService;

    @PostMapping("/registry")
    @ApiOperation(value = "注册用户", notes = "通过form表单进行用户注册", consumes = "application/x-www-form-urlencoded")
    public Response registry(@RequestParam String username,
                             @RequestParam String password) {
        UserEntity usr = new UserEntity().setName(username).setPassword(password);
        userService.registry(usr);
        return Response.success();
    }

    @PostMapping("/login")
    @ApiOperation(value = "登录用户", notes = "通过form表单进行用户登录", consumes = "application/x-www-form-urlencoded")
    public Response<String> login(@RequestParam String username,
                                  @RequestParam String password) throws Exception {
        Integer EXPIRE_TIME = 1000 * 60 * 60 * 1;
        UserEntity usr = userService.login(username, password);

        String jwt = Jwts.builder()
                .setSubject(usr.getName())
                .setExpiration(new Date(EXPIRE_TIME))
                .compact();
        return Response.success(jwt);

    }
}