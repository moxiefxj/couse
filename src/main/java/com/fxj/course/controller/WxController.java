package com.fxj.course.controller;

import com.alibaba.fastjson.JSONObject;
import com.fxj.course.entity.CodeMsg;
import com.fxj.course.entity.Result;
import com.fxj.course.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class WxController {
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("login")
    public Result login(@RequestBody HashMap<String, String> map ) {
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        if(StringUtils.isBlank(map.get("code"))) {
            Result.error(CodeMsg.BIND_ERROR.fillAgs(map.get("code")));
        }
        Map<String, String> params = new HashMap<String,String>();
        params.put("appid","wxfe8e79cd102946ce");
        params.put("secret","ee31dc6ab671a7cdb80689dafca000e9");
        params.put("js_code",map.get("code"));
        params.put("grant_type","authorization_code");
        String wxResult = HttpClientUtil.doGet(url, params);
        System.out.println(wxResult);
        JSONObject jsonObject = (JSONObject) JSONObject.parse(wxResult);
        String sessionId = DigestUtils.md5DigestAsHex(wxResult.getBytes());
        redisTemplate.boundValueOps(sessionId).set(jsonObject);
        return  Result.success(sessionId,200);
    }
}
