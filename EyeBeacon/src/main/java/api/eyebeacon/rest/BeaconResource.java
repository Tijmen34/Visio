package api.eyebeacon.rest;

import api.eyebeacon.model.Beacon;
import api.eyebeacon.model.DatabaseConn;
import api.eyebeacon.rest.model.ClientError;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.bson.Document;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.json.JSONException;

/**
 * adds beacons to db
 *
 * @author
 *
 */
@Path("/beacons")
public class BeaconResource {

    private static DatabaseConn db = new DatabaseConn();
    private final ObjectWriter OBJECT_WRITER = new ObjectMapper().writer()
            .withDefaultPrettyPrinter();

    /**
     * Get a list of al beacons
     *
     * @return JSON response with the beacons or an error.
     * @throws JSONException
     * @throws IOException
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBeaconList() throws JSONException, IOException {

//      Load alist of beacons
        FindIterable beaconColl = db.findDocsInColl("beaconAmsterdam");

        // Check if there are beacons in the list
        if (db.findDocsInColl("beaconAmsterdam") == null) {
            // Create the client error
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ClientError("No beacons were found"))
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods",
                            "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .build();
        }

//       Format the array to JSON
        String json = OBJECT_WRITER.writeValueAsString(beaconColl);

        return Response.ok(json, MediaType.APPLICATION_JSON)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods",
                        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{Name}")
    public Response returnBeacon(@PathParam("Name") String name) 
            throws JSONException, IOException {

        DatabaseConn db = new DatabaseConn();
        
        FindIterable oke2 = db.findDocsInColl("beaconAmsterdam");
        MongoCollection<Document> oke = db.getBeaconCollection();
        
        FindIterable goedeBeacon = oke.find(eq("Name", name));
        
        if (oke2 == null || goedeBeacon == null) {
            // Create the client error
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ClientError("No beacons were found"))
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods",
                            "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .build();
        }
        
        String json = OBJECT_WRITER.writeValueAsString(goedeBeacon);
        
        
        
        
        
        return Response.ok(json, MediaType.APPLICATION_JSON)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods",
                        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();
    }

    /**
     * Generate testing beacons
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Beacon addBeacon(Beacon beacon) {
        System.out.println("beacon" + beacon);
        return db.addBeacon(beacon);

    }
    
        /**
     * Put method for beacons
     * @param beacon
     * @return 
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Beacon putBeacon(Beacon beacon) {
        System.out.println("Beacon " + beacon);
        return db.putBeacon(beacon);

    }

    @DELETE
    @Path("{description}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBeacon(@PathParam("description") String Description) {
        return Response.ok(db.deleteBeacon(Description), MediaType.APPLICATION_JSON)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods",
                        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();
    }

}
