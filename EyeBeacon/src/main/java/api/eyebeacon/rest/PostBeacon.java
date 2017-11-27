package api.eyebeacon.rest;

import api.eyebeacon.model.Beacon;
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
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import org.bson.Document;

/**
 * Retrive Beacon List or an individual beacon specified by ID
 *
 */


public class PostBeacon {

    // Object writer to write arrays to JSON
    private final ObjectWriter OBJECT_WRITER = new ObjectMapper().writer()
            .withDefaultPrettyPrinter();

    /**
     * Get a list of al beacons
     *
     * @return JSON response with the beacons or an error.
     * @throws JSONException
     * @throws IOException
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addBeacon() {

        DatabaseConn db = new DatabaseConn();
        // db.addBeacon("asdfhasljkhf", 53, 23, "heel ver weg", 0, 0);

    }

//    /**
//     *
//     * @author Laura
//     */
//    @Path("beacons")
//    public class PostBeacon {
//
//        private final ObjectWriter OBJECT_WRITER = new ObjectMapper().writer()
//                .withDefaultPrettyPrinter();
//
//        @POST
//    
//    
//    
//    
//
//    
//    }

}
