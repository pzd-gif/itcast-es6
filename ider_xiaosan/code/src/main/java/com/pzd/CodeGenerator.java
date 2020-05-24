package com.pzd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class CodeGenerator {

    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        final String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + "/src/main/java")
                .setAuthor(scanner("请输入作者："))
                .setOpen(false)
                .setBaseColumnList(true)
                .setBaseResultMap(true)
                .setDateType(DateType.ONLY_DATE);
        mpg.setGlobalConfig(globalConfig);

        // 数据源配置
        //TODO
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/zg4_month?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123123");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();

        pc.setParent("com." + globalConfig.getAuthor() + "");
        pc.setEntity("entity");
        pc.setController("controller");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        mpg.setPackageInfo(pc);

        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };

        String templatePath = "/templates/mapper.xml.ftl";

        List<FileOutConfig> fileOutConfigList = new ArrayList<FileOutConfig>();
        fileOutConfigList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "/src/main/resources/mapper/" + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(fileOutConfigList);
        mpg.setCfg(injectionConfig);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        //去掉前缀
        //TODO
        strategy.setTablePrefix("t_");

        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}