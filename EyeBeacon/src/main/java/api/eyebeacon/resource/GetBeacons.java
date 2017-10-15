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

    private final ObjectWriter OBJECT_WRITER = new ObjectMapper().writer()
            .withDefaultPrettyPrinter();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response returnBeaconList() throws JSONException, IOException {
        BeaconResource beaconList = new BeaconResource();
        
        String json = OBJECT_WRITER.writeValueAsString(beaconList);

        beaconList = null;
        Beacon.resetId();
        
        //return Response.status(Response.Status.OK).entity(beaconList).build();

        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{beaconId}")
    public Response returnBreacon(@PathParam("beaconId") int id)
            throws JSONException, IOException {

        BeaconResource beaconlist = new BeaconResource();

        Beacon returnBeacon = null;

        for (Beacon beacon : beaconlist.getBeacons()) {
            if (beacon.getId() == id) {
                returnBeacon = beacon;
            }
        }

        if (returnBeacon == null) {
            beaconlist = null;
            Beacon.resetId();

            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ClientError("No beacon found with id: " + id)).build();
        }

        beaconlist = null;
        Beacon.resetId();
        
        return Response.status(Response.Status.OK).entity(returnBeacon).build();
        
        /*String json = OBJECT_WRITER.writeValueAsString(returnBeacon);
        return Response.ok(json, MediaType.APPLICATION_JSON).build();*/

    }
}
