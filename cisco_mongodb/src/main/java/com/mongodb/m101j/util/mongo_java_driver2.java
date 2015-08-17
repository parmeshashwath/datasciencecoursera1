package com.mongodb.m101j.util;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.m101j.util.Helpers.printJson;
/**
 * Created by parma on 8/15/2015.
 */
public class mongo_java_driver2 {
    public static void main(String[] args) {


        MongoClient client = new MongoClient();
        MongoDatabase db=client.getDatabase("test");
       MongoCollection coll= db.getCollection("test");
        coll.drop();
        for(int i=0;i<10;i++)
        {
            Document doc=new Document("x",i);
            coll.insertOne(doc);
        }
        Document first=(Document) coll.find().first();
printJson(first);
        List<Document> all= (List<Document>) coll.find().into(new ArrayList<Document>());
        for(Document c: all)
            printJson(c);

        MongoCursor<Document>cursor= coll.find().iterator();
        try {
        while(cursor.hasNext())
        {
            Document docc=cursor.next();
            printJson(docc);
        }
        }finally {
            cursor.close();
        }
       long cnt= coll.count();
        System.out.println(cnt);
    }


}
