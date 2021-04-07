package com.fxj.course.controller;

import com.fxj.course.entity.Classfiy;
import com.fxj.course.entity.CodeMsg;
import com.fxj.course.entity.Result;
import com.fxj.course.service.ClassfiyService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fengxiaojing
 * @since 2021-02-25
 */
@RestController
@RequestMapping("/")

public class ClassfiyController {
    @Autowired
    public ClassfiyService classfiyService;
    CodeMsg codeMsg = new CodeMsg();

    @GetMapping("getClassfiy")
    public Result selectAll(){
        List<Classfiy> classfiys = classfiyService.selectAll();
        System.out.println(classfiys);
        return Result.success(classfiys,200);
    }
    @GetMapping("getClassfiyPrimary")
    public  Result getClassfiyPrimary(){
        List<Classfiy> classfiys = classfiyService.selectPrimary();
        return Result.success(classfiys,200);
    }
     @PostMapping("updateClassfiyPrimary")
    public Result updateClassfiyPrimary(@RequestBody HashMap<String,String> map){
         Integer i = classfiyService.updatePrimary(map);
         if(i!=0){
             return Result.success("更新成功",200);
         }else {
             return Result.error(new CodeMsg(500,"更新失败"));
         }
     }
     @PostMapping("delClassfiyPrimary")
    public Result delClassfiyPrimary(@RequestBody HashMap<String,Integer> map){
         Integer i = classfiyService.delPrimary(map);
         if(i == -1){
             return Result.error(new CodeMsg(500,"该分类下还有目录，不可删除"));
         }
         return Result.success("hh",200);
     }

     @PostMapping("getClassfiySecond")
    public Result getClassfiySecond(@RequestBody HashMap<String, Integer> map){
         List<Classfiy> classfiySecond = classfiyService.getClassfiySecond(map);
         return Result.success(classfiySecond,200);
     }
     @PostMapping("modifyClassfiy")
    public Result modifyClassfiy(@RequestBody HashMap<String,String> map){
         Integer integer = classfiyService.modifyClassfiy(map);
         System.out.println(integer);
         if(integer != 0){
             return Result.success("修改成功",200);
         }else {
             return Result.error(codeMsg.SERVER_ERROR);
         }
     }

}
