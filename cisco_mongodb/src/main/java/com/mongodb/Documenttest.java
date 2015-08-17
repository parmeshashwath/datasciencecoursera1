package com.mongodb;

import javax.swing.text.Document;
import java.util.Arrays;
import static com.mongodb.m101j.util.Helpers.printJson;
/**
 * Created by parma on 8/15/2015.
 */
public class Documenttest {
    public static void main(String[] args) {
        org.bson.Document doc=new org.bson.Document().append("str","azad").append("int",1)
               .append("double",1L).append("list",Arrays.asList(1,2,3)).append("doc",new org.bson.Document("x",0)).append("null",null);
        printJson(doc);





    }
}
