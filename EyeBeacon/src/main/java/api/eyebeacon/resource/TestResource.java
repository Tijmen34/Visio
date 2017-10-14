/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.eyebeacon.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author erik
 */
@Path("hallo")
public class TestResource {
    
    private String message = "Hoi, ik hoop dat deze tering zooi nu een keer werkt.";
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return this.message;
    }
    
}
