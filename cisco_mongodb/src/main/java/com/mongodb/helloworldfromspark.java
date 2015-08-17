package com.mongodb;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;


/**
 * Created by parma on 8/6/2015.
 */
public class helloworldfromspark {
   public static void main(String[] args) {

        Spark.get("ass",new Route() {
              @Override
              public Object handle(Request request, Response response) throws Exception {
                  return "hello azad";
              }
          });


   }
}
