package com.free;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException, TemplateException {
        //1.创建配置类
        Configuration configuration=new Configuration(Configuration.getVersion());
        //2.设置模板所在的目录
        configuration.setDirectoryForTemplateLoading(new File("D:\\1\\Maevn\\xiaowu\\freemarkerdemo\\src\\main\\resources"));
    //3.设置字符集
        configuration.setDefaultEncoding("utf-8");
        //4.加载模板
        Template template = configuration.getTemplate("head.ftl");
        //5.创建数据模型
        Map map=new HashMap();
        map.put("name", "张三 ");
        map.put("message", "欢迎来到神奇的品优购世界！");
        //map.put("success", true);

        map.put("point",1846523856);

        map.put("today",new Date());
        
        List goodsList=new ArrayList();
        Map goods1=new HashMap();
        goods1.put("name", "苹果");
        goods1.put("price", 5.8);
        Map goods2=new HashMap();
        goods2.put("name", "香蕉");
        goods2.put("price", 2.5);
        Map goods3=new HashMap();
        goods3.put("name", "橘子");
        goods3.put("price", 3.2);
        goodsList.add(goods1);
        goodsList.add(goods2);
        goodsList.add(goods3);
        map.put("goodsList", goodsList);



        //6.创建Writer对象
        Writer out =new FileWriter(new File("d:\\1\\head.html"));
        //7.输出
        template.process(map, out);
        //8.关闭Writer对象
        out.close();
    }
}
