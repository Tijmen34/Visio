package api.eyebeacon.model;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

/**
 *
 * @author Thijs Timmermans <thijs-97@hotmail.com>
 */
public class DatabaseConn {

    private static MongoClientURI uri = new MongoClientURI("mongodb://eyebeacon:UefWS7GMmiBz2bX2@eyebeacon-shard-00-00-zvquw.mongodb.net:27017,eyebeacon-shard-00-01-zvquw.mongodb.net:27017,eyebeacon-shard-00-02-zvquw.mongodb.net:27017/eyebeacon?ssl=true&replicaSet=EyeBeacon-shard-0&authSource=admin");
    private static MongoClient mongoClient = new MongoClient(uri);

    private static MongoDatabase database = mongoClient.getDatabase("eyebeacon");

    // private static MongoCollection<Document> collection = database.getCollection("beacon");
    private static final ObjectWriter OBJECT_WRITER = new ObjectMapper().writer()
            .withDefaultPrettyPrinter();

//    public static void main(String[] args) throws IOException {
//        
//       String json = OBJECT_WRITER.writeValueAsString(findDocsInColl("beacon"));
//       String json2 = OBJECT_WRITER.writeValueAsString(updateDoc());
//       System.out.println(json2);
//       System.out.println(json);
//       
//    }
    
    public void addBeacon(Beacon b) {

        Document doc = new Document("name", b.getName())
                .append("UUID", b.getUUID())
                .append("Major", b.getMajor())
                .append("Minor", b.getMinor())
                .append("latitude", b.getLatitude())
                .append("longitutde", b.getLongitude());

        MongoCollection<Document> collection = database.getCollection("beacon");
        collection.insertOne(doc);

    }

    public FindIterable findDocsInColl(String collName) {

        MongoCollection<Document> collection = database.getCollection(collName);
        FindIterable<Document> findIterable = collection.find(new Document());
        return findIterable;

    }

    public UpdateResult updateDoc() {

        BasicDBObject doc = new BasicDBObject();
        doc.append("$set", new BasicDBObject().append("UUID", "asjhdgfhdksajgsdf"));

        BasicDBObject searchQuery = new BasicDBObject().append("name", "Entrance HvA - BPH");

        MongoCollection<Document> collection = database.getCollection("beacon");
        UpdateResult findIterable = collection.updateMany(searchQuery, doc);

        return findIterable;

    }

}
