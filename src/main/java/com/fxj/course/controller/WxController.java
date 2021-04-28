package com.fxj.course.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fxj.course.entity.CodeMsg;
import com.fxj.course.entity.Result;
import com.fxj.course.entity.User;
import com.fxj.course.service.UserService;
import com.fxj.course.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class WxController {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    public UserService userService;

    public CodeMsg codeMsg;

    @PostMapping("login")
    public Result login(@RequestBody HashMap<String, Object> map ) {
        JSONObject jsonObj;
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        String code = String.valueOf(map.get("code"));
        if(StringUtils.isBlank(code)) {
            Result.error(CodeMsg.BIND_ERROR.fillAgs(code));
        }
        Map<String, String> params = new HashMap<String,String>();
        params.put("appid","wxfe8e79cd102946ce");
        params.put("secret","ee31dc6ab671a7cdb80689dafca000e9");
        params.put("js_code",code);
        params.put("grant_type","authorization_code");
        String wxResult = HttpClientUtil.doGet(url, params);
        JSONObject jsonObject = (JSONObject) JSONObject.parse(wxResult);
        //验证是否注册
        User user = userService.checkUser(String.valueOf(jsonObject.get("openid")));
        if(user == null){
//           添加用户信息
            HashMap map1 = new HashMap();
            map1.put("userInfo",map.get("userInfo"));
            map1.put("openId",String.valueOf(jsonObject.get("openid")));
            Boolean a = userService.setUserInfo(map1);
            if(!a){
                return Result.error(new CodeMsg(500,"更新用户信息失败"));
            }
        }

        String token =  JWT.create().withAudience(String.valueOf(jsonObject.get("openid"))).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(String.valueOf(jsonObject.get("openid"))));
        redisTemplate.boundValueOps(token).set(jsonObject);
        return  Result.success(token,200);
    }
}
