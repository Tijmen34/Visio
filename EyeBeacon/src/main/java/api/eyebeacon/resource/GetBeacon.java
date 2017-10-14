package api.eyebeacon.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Return information about a single beacon
 *
 * @author Erik Wolters <erik.wolters@hva.nl>
 */
@Path("beacons")
@Consumes(MediaType.TEXT_PLAIN)
public class GetBeacon {
    
}