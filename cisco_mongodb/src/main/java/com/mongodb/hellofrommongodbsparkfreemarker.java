package com.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.bson.Document;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;

/**
 * Created by parma on 8/15/2015.
 */
public class hellofrommongodbsparkfreemarker {
    public static void main(String[] args) {
        final Configuration config=new Configuration();
        config.setClassForTemplateLoading(hellofrommongodbsparkfreemarker.class, "/");
        Spark.get("week2", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {


                    StringWriter writer = new StringWriter();
                    MongoClient client = new MongoClient();
                    MongoDatabase database = client.getDatabase("test");
                    MongoCollection collection = database.getCollection("test");
                    collection.drop();
                    collection.insertOne(new Document("name", "Mongodb"));
                try {
                    Template template = config.getTemplate("hello.ftl");
                    Document doc= (Document) collection.find().first();
                    template.process(doc, writer);

                }catch (Exception e){
                    System.out.println("wrong");

                }
                return writer;

            }
            });
        }
}