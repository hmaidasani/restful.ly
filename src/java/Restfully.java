import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.util.List;
import java.util.Set;

public class Restfully {
    MongoClient mongoClient;
    DB db;
    DBCollection collection;


    public Restfully(String dbname) throws Exception {
        // connect to the local database server
        mongoClient = new MongoClient();

        // get handle to dbname
        db = mongoClient.getDB(dbname);

        // Authenticate - optional
        // boolean auth = db.authenticate("foo", "bar");

        // get the collection object to work with - use dbname as default collection since using only one
        collection = db.getCollection(dbname);

        // collection.drop();

    }

    public void push(String jsonObj) throws Exception {
        Object obj = com.mongodb.util.JSON.parse(jsonObj);
        DBObject dbObj = (DBObject) obj;
        collection.save(dbObj);
    }



    public static void main(String[] args) throws Exception{
        String dbname = "RestfullyTest";
        Restfully myDataRef = new Restfully(dbname);
        myDataRef.push("{name: \"Perry\", text: \"Restfully FTW!!\"}");

        DBCursor cursor = myDataRef.collection.find();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } finally {
            cursor.close();
        }
    }

}
