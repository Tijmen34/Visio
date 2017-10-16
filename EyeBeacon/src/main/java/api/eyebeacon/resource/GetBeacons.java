package api.eyebeacon.resource;

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
import api.eyebeacon.model.ClientError;

/**
 * Retrive Beacon List
 *
 * @author Erik Wolters <erik.wolters@hva.nl>
 */
@Path("beacons")
public class GetBeacons {

    // Object writer to write arrays to JSON
    private final ObjectWriter OBJECT_WRITER = new ObjectMapper().writer()
            .withDefaultPrettyPrinter();

    /**
     * Get a list of aal beacons
     * 
     * @return JSON response with the beacons or an error.
     * @throws JSONException
     * @throws IOException 
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response returnBeaconList() throws JSONException, IOException {
        
        // Load alist of beacons
        BeaconResource beaconList = new BeaconResource();

        // Check if there are beacons in the list
        if (beaconList.getBeacons().length == 0
                || beaconList.getBeacons() == null) {
            // Create the client error
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ClientError("No beacons were found")).build();
        }

        // Format the array to JSON
        String json = OBJECT_WRITER.writeValueAsString(beaconList);

        // Reset the beacon list.
        beaconList = null;
        Beacon.resetId();

        // Create a response with the beacons
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }
    
    /**
     * Get an individual beacon
     * 
     * @param id int The id of the beacon to return
     * @return JSON with client error or a single beacon
     * @throws JSONException
     * @throws IOException 
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{beaconId}")
    public Response returnBreacon(@PathParam("beaconId") int id)
            throws JSONException, IOException {

        // Load a list of beacons
        BeaconResource beaconlist = new BeaconResource();

        // Create an instance of beacon to return
        Beacon returnBeacon = null;
        
        // Loop trough all beacons and find the one with a matching ID
        for (Beacon beacon : beaconlist.getBeacons()) {
            if (beacon.getId() == id) {
                returnBeacon = beacon;
            }
        }

        // Check if there is a matching beacon
        if (returnBeacon == null) {
            
            // Reset the beacon list
            beaconlist = null;
            Beacon.resetId();
            
            // Create a client error
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ClientError("No beacon found with id: " + id))
                    .build();
        }

        // Reset the beaconlist
        beaconlist = null;
        Beacon.resetId();

        // Return the requested beacon
        return Response.status(Response.Status.OK).entity(returnBeacon).build();
    }
}