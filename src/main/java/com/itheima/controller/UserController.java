package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import com.itheima.utils.Md5Util;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$")String password){

            //查询用户
            User u = userService.findByUserName(username);
            if(u==null){
                //没占用   //注册
                userService.register(username,password);
                return Result.success();
            }else{
                return Result.error("用户名已被占用");

        }
    }
    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$")String password){
//        根据用户名查询用户
        User loginUser=userService.findByUserName(username);
        if(loginUser==null){
            return Result.error("用户名错误");
        }
        if(Md5Util.getMD5String(password).equals(loginUser.getPassword())){
            return  Result.error("jwt token");
        }
        return Result.error("密码错误");
    }

}
