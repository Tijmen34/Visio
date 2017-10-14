package api.eyebeacon.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Retrive Beacon List
 *
 * @author Erik Wolters <erik.wolters@hva.nl>
 */
@Path("beacons")
public class GetBeacons {
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String returnBeaconList() {
        BeaconResource beaconlist = new BeaconResource();
        
        StringBuilder sb = new StringBuilder();
        
        for(Beacon beacon : beaconlist.getBeacons()) {
            sb.append("<ul>");
            sb.append("<li>").append(beacon.getId()).append("</li>");
            sb.append("<li>").append(beacon.getName()).append("</li>");
            sb.append("<li>").append(beacon.getLatitude()).append("</li>");
            sb.append("<li>").append(beacon.getLongtitude()).append("</li>");
            sb.append("</ul><br />");
        }
        
        beaconlist = null;
        
        return sb.toString();
    }
}
