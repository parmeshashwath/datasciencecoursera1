package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by parma on 8/6/2015.
 */
public class helloworldfromfreemarker {
    public static void main(String[] args) {
        Configuration config=new Configuration();
        config.setClassForTemplateLoading(helloworldfromfreemarker.class, "/");
        try {
            Template hellotemplate = config.getTemplate("hello.ftl");
            StringWriter writer = new StringWriter();
            Map<String,String> hellomap=new HashMap<String,String>();
            hellomap.put("name","AZAD1");
            hellotemplate.process(hellomap,writer);
            System.out.println(writer);

        }
        catch(Exception e) {
        e.printStackTrace();
        }
        }


    }

