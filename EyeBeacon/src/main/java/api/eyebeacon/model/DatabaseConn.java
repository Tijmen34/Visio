package api.eyebeacon.model;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thijs Timmermans <thijs-97@hotmail.com>
 */
public class DatabaseConn {

    private static MongoClientURI uri = new MongoClientURI("mongodb://eyebeacon:UefWS7GMmiBz2bX2@eyebeacon-shard-00-00-zvquw.mongodb.net:27017,eyebeacon-shard-00-01-zvquw.mongodb.net:27017,eyebeacon-shard-00-02-zvquw.mongodb.net:27017/eyebeacon?ssl=true&replicaSet=EyeBeacon-shard-0&authSource=admin");
    private static MongoClient mongoClient = new MongoClient(uri);

    private static MongoDatabase database = mongoClient.getDatabase("eyebeacon");

    private static MongoCollection<Document> collection = database.getCollection("test");


    public static void createDoc() {

        Document doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
                .append("info", new Document("x", 203).append("y", 102));

        collection.insertOne(doc);
    }

    public Document findDoc(){
        
        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());
        return myDoc;
        
    }
    
}
