package api.eyebeacon.rest;

import api.eyebeacon.model.Beacon;
import api.eyebeacon.model.DatabaseConn;
import api.eyebeacon.rest.model.ClientError;
import com.mongodb.client.FindIterable;
import io.swagger.oas.annotations.Operation;
import com.mongodb.client.result.DeleteResult;
import io.swagger.oas.annotations.Operation;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    @Operation(summary = "Get beacons",
            description = "Get list of beacons")
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

    /**
     * Generate testing beacons
     */
     @Operation(summary = "Post beacon",
            description = "Post a beacon")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Beacon addBeacon(Beacon beacon) {
        System.out.println("beacon" + beacon);
        return db.addBeacon(beacon);

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
