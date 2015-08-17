package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by parma on 8/6/2015.
 */
public class hellofromsparkfreemarker {
    public static void main(String[] args) {
        final Configuration config=new Configuration();
        config.setClassForTemplateLoading(hellofromsparkfreemarker.class,"/test/");
        Spark.get("aa", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                StringWriter writer;
                writer = null;
                try {
                    Template hellotemplate = config.getTemplate("hell03.ftl");
                    writer = new StringWriter();
                    Map<String, String> hellomap = new HashMap<String, String>();
                    hellomap.put("name1", "AZAD_parmesh");
                    System.out.println(hellomap.size());
                    hellotemplate.process(hellomap, writer);
                    System.out.println(writer);

                } catch (Exception e) {
                    e.printStackTrace();

                }
                return writer;
            }
        });


    }
}
