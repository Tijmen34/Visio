package api.eyebeacon.rest;

import api.eyebeacon.model.DatabaseConn;
import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.json.JSONException;
import api.eyebeacon.rest.model.ClientError;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;

/**
 * Retrive Beacon List or an individual beacon specified by ID
 *
 * @author 
 */  
@Path("/beacons")
public class GetBeacons {

    // Object writer to write arrays to JSON
    private final ObjectWriter OBJECT_WRITER = new ObjectMapper().writer()
            .withDefaultPrettyPrinter();
    
     BeaconResource  BeaconResource = new  BeaconResource();

    /**
     * Get a list of al beacons
     *
     * @return JSON response with the beacons or an error.
     * @throws JSONException
     * @throws IOException
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response returnBeaconList() throws JSONException, IOException {

//      Load alist of beacons
        DatabaseConn db = new DatabaseConn();
        FindIterable beaconColl = db.findDocsInColl("beacon");

//        // Check if there are beacons in the list
//        if (beaconList.getBeacons().length == 0
//                || beaconList.getBeacons() == null) {
//            // Create the client error
//            return Response.status(Response.Status.NOT_FOUND)
//                    .entity(new ClientError("No beacons were found"))
//                    .header("Access-Control-Allow-Origin", "*")
//                    .header("Access-Control-Allow-Methods", 
//                            "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//                    .build();
//        }

//       Format the array to JSON
        String json = OBJECT_WRITER.writeValueAsString(beaconColl);

        return Response.ok(json, MediaType.APPLICATION_JSON)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods",
                        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();

    }

}