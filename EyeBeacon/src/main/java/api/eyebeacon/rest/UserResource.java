/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.eyebeacon.rest;

import api.eyebeacon.model.Beacon;
import api.eyebeacon.model.DatabaseConn;
import api.eyebeacon.model.User;
import api.eyebeacon.rest.model.ClientError;
import com.mongodb.client.FindIterable;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.json.JSONException;

/**
 *
 * @author feest
 */
public class UserResource {
    DatabaseConn db = new DatabaseConn();
    private final ObjectWriter OBJECT_WRITER = new ObjectMapper().writer()
            .withDefaultPrettyPrinter();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserList() throws JSONException, IOException {

//      Load alist of beacons
        DatabaseConn db = new DatabaseConn();
        FindIterable userColl = db.findDocsInColl("users");

        // Check if there are beacons in the list
//        if (db.findDocsInColl("users") == null) {
//            // Create the client error
//            return Response.status(Response.Status.NOT_FOUND)
//                    .entity(new ClientError("No beacons were found"))
//                    .header("Access-Control-Allow-Origin", "*")
//                    .header("Access-Control-Allow-Methods",
//                            "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//                    .build();
//        }

//       Format the array to JSON
        String json = OBJECT_WRITER.writeValueAsString(userColl);
        userColl = null;
        return Response.ok(json, MediaType.APPLICATION_JSON)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods",
                        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();

    }
    
    
    
    
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User addUser(User user){
        System.out.println(user);
        return db.addUser(user);  
        
    }
}
