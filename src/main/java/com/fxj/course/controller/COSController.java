package com.fxj.course.controller;

import com.fxj.course.entity.CodeMsg;
import com.fxj.course.entity.Result;
import com.fxj.course.utils.TencentCOSUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/cos")
public class COSController {

    CodeMsg codeMsg = new CodeMsg();

    @PostMapping("upload")
    public Object upload(@RequestParam(value = "file")MultipartFile file){
        if(file == null ){
            return Result.error(codeMsg.BIND_ERROR);
        }
        String uploadfile = TencentCOSUtil.uploadfile(file);

        return Result.success(uploadfile,200);
    }
}
