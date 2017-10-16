package api.eyebeacon.config;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Set the base path for the API
 *
 * @author Erik Wolters <erik.wolters@hva.nl>
 */
@ApplicationPath("api")
public class App extends ResourceConfig {

}
