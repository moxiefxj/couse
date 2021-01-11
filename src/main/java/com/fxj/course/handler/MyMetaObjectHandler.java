package com.fxj.course.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    //    插入时的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ...");
        log.info(String.valueOf(LocalDateTime.now()));
        this.strictInsertFill(metaObject,"createTime", () -> LocalDateTime.now(), LocalDateTime.class);
        this.strictUpdateFill(metaObject,"updateTime", () -> LocalDateTime.now(), LocalDateTime.class);
    }

    //    更新时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ...");
        log.info(String.valueOf(LocalDateTime.now()));
        this.strictUpdateFill(metaObject,"updateTime", () -> LocalDateTime.now(), LocalDateTime.class);
    }
}
