package com.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.m101j.util.Helpers.printJson;

/**
 * Created by parma on 8/15/2015.
 */
public class mongo_java_driver1 {
    public static void main(String[] args) {
        MongoClient client=new MongoClient();
        MongoDatabase db=client.getDatabase("test");
        MongoCollection<Document> coll=db.getCollection("test2");
        coll.drop();
        Document doc=new Document().append("name","smith").append("age", 22).append("company","cisco");
        printJson(doc);
        coll.insertOne(doc);
        printJson(doc);
        coll.insertOne(doc);

    }
}
