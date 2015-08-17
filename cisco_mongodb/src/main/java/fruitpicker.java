import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by parma on 8/7/2015.
 */
public class fruitpicker {
    public static void main(String[] args) {
        final Configuration config = new Configuration();
        config.setClassForTemplateLoading(fruitpicker.class, "/");
        Spark.get("/select", new Route() {

            @Override
            public Object handle(Request request, Response response) throws Exception {
                Template template = config.getTemplate("fruitpicker.ftl");
                Map<String, Object> fruitmap = new HashMap<String, Object>();
                StringWriter writer = new StringWriter();
                fruitmap.put("fruits", Arrays.asList("apple", "banana", "mango", "orange"));


                template.process(fruitmap, writer);
                System.out.println(writer);
                return writer;
            }
        });
        Spark.post("/fruit_picker", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                final String fruit=request.queryParams("fruit");
                StringWriter writer=new StringWriter();
                if(fruit==null)
                {
                    return "why don't you ick one";
                }
                else {
                    return "your favourite fruite is" + fruit;
                }
            }
        });
    }
}
