/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.eyebeacon.config;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Set the base path of the API
 *
 * @author Erik Wolters <erik.wolters@hva.nl>
 */
@ApplicationPath("api")
public class App extends ResourceConfig {

}
