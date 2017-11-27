package api.eyebeacon.rest;

import api.eyebeacon.model.DatabaseConn;
import api.eyebeacon.model.POI;
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

/**
 * Retrieve a list of POIS
 *
 * @author Tijmen Stor <Tijmen.Stor@hva.nl>
 */
@Path("/pois")
public class GetPOIS {

    // Object writer to write arrays to JSON
    private final ObjectWriter OBJECT_WRITER = new ObjectMapper().writer()
            .withDefaultPrettyPrinter();

    /**
     * Get a list of POIS
     * 
     * @return JSON response with the POIS or an error
     * @throws JSONException
     * @throws IOException 
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response returnPOIList() throws JSONException, IOException {
        
        // Load all POIS
        DatabaseConn db = new DatabaseConn();
        FindIterable poiColl = db.findDocsInColl("poi");

//        // Check if there are POIS in the list
//        if (poiColl.equals(0)
//                || db.isEmpty(poiColl)  ) {
//            // Create the client error
//            return Response.status(Response.Status.NOT_FOUND)
//                    .entity(new ClientError("No POI were found"))
//                    .header("Access-Control-Allow-Origin", "*")
//                    .header("Access-Control-Allow-Methods", 
//                            "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//                    .build();
//        }

        // Format the array to JSON
        String json = OBJECT_WRITER.writeValueAsString(poiColl);

        // Reset the POI list.
        poiColl = null;

        // Create a response with the POIS
        return Response.ok(json, MediaType.APPLICATION_JSON)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", 
                        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();
    }
    
//    /**
//     * Get an individual POI
//     * 
//     * @param id int The id of the POI to return
//     * @return JSON with client error or a single POI
//     * @throws JSONException
//     * @throws IOException 
//     */
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/{poiId}")
//    public Response returnPOI(@PathParam("poiId") int id)
//            throws JSONException, IOException {
//
//        // Load all POIS
//        DatabaseConn db = new DatabaseConn();
//        FindIterable poiColl = db.findDocsInColl("poi");
//
//        // Create an instance of POI to return
//        POI returnPOI = null;
//        
//        // Loop trough all POIS and find the one with a matching ID
//        for (POI poi : poiColl.) {
//            if (poi.getId() == id) {
//                returnPOI = poi;
//            }
//        }
//
//        // Check if there is a matching POI ID
//        if (returnPOI == null) {
//            
//            // Reset the POI list
//            poiColl = null;
//            
//            // Create a client error
//            return Response.status(Response.Status.NOT_FOUND)
//                    .entity(new ClientError("No POI found with id: " + id))
//                    .header("Access-Control-Allow-Origin", "*")
//                    .header("Access-Control-Allow-Methods", 
//                            "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//                    .build();
//        }
//
//        // Reset the list of POIS
//        poiColl = null;
//
//        // Return the requested POI
//        return Response.status(Response.Status.OK).entity(returnPOI)
//                .header("Access-Control-Allow-Origin", "*")
//                .header("Access-Control-Allow-Methods", 
//                        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//                .build();
//    }
    
//    
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public POI addPOI(POI p){
//        
//        
//    }
}
