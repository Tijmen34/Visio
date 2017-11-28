package api.eyebeacon.rest;

import api.eyebeacon.model.Beacon;
import api.eyebeacon.model.DatabaseConn;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

/**
 * Generate a hardcoded list of beacons for testing purposes
 * 
 * @author  
 * @deprecated Only used for testing
 */
//@Deprecated
@Path("/beacons")

public class BeaconResource {
      DatabaseConn db = new DatabaseConn();
    private final ObjectWriter OBJECT_WRITER = new ObjectMapper().writer()
            .withDefaultPrettyPrinter();
    
   
    /**
     * Generate testing beacons
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Beacon addBeacon(Beacon beacon){
        System.out.println("beacon"+ beacon);
        return db.addBeacon(beacon);  
        
    }
}
