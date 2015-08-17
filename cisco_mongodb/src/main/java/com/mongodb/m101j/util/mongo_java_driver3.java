package com.mongodb.m101j.util;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.UpdateResult;
import org.bson.BSON;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.m101j.util.Helpers.printJson;

/**
 * Created by parma on 8/15/2015.
 */
public class mongo_java_driver3 {
    public static void main(String[] args) {


        MongoClient client = new MongoClient();
        MongoDatabase database = client.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("test");
        collection.drop();
        for (int i=0;i<10;i++)
        {
            collection.insertOne(new Document("x",i).append("y", i));
        }

        Document fil=new Document().append("x",10).append("y",new Document("$gt",5));
       // Bson filter=fil;
        /*Bson filter= and(eq("x", 10),gt("y",6));
        Bson projection= Projections.fields(Projections.include("y"), Projections.exclude("_id"));
        Bson sorts= Sorts.orderBy(Sorts.ascending("x"),Sorts.descending("y"));
        printJson(fil);
        Document d=collection.find(filter).projection(projection).sort(sorts).skip(1).first();
        printJson(d);
        System.out.print(collection.count(fil));*/
      //collection.replaceOne(eq("x", 8), new Document("x", 20).append("y", 30));
        collection.updateOne(eq("x",10),new Document("$set",new Document("x",30).append("y",40)),new UpdateOptions().upsert(true));
        collection.deleteMany(gt("x",7));
        MongoCursor cursor=collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                 Document du= (Document) cursor.next();
                printJson(du);
            }
        }
        finally {
            cursor.close();
        }
    }
}
