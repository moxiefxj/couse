package com.fxj.course;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

//代码自动生成器
public class AutoCode {
    public static void main(String[] args) {
//        构建代码自动生成器 对象
        AutoGenerator mpg = new AutoGenerator();
//        配置策略

//        1。全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");//当前项目路径
        gc.setOutputDir(projectPath+"/src/main/java");
        gc.setAuthor("fengxiaojing");
        gc.setOpen(false);
        gc.setFileOverride(false);//是否覆盖
        gc.setServiceName("%sService");//去掉service的I前缀
        gc.setIdType(IdType.AUTO);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

//        2.设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://localhost:3306/db_classRoom?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8");
        dsc.setUsername("root");
        dsc.setPassword("980903");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

//        3.包的设置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("course");
        pc.setParent("com.fxj");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

//        4.策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("adjust");//设置映射的表名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true); //自动lombok

        strategy.setLogicDeleteFieldName("deleted");
//        自动填充配置
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
//        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
//        tableFills.add(updateTime);
        strategy.setTableFillList(tableFills);

//        乐观锁
//        strategy.setVersionFieldName("version");
//
//        strategy.setRestControllerStyle(true);
//        strategy.setControllerMappingHyphenStyle(true);//localhost:8080/hello_id_2

        mpg.setStrategy(strategy);

        mpg.execute();// 执行
    }
}

