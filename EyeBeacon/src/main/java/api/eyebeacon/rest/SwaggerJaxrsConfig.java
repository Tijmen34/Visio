package api.eyebeacon.rest;



import api.eyebeacon.rest.BeaconResource;
import api.eyebeacon.rest.PoiResource;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class SwaggerJaxrsConfig extends Application{
        @Override
        
public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();

        
        resources.add(BeaconResource.class);
        resources.add(PoiResource.class);
        //resources.add(SecondResource.class);
        //...

        resources.add(io.swagger.jaxrs2.integration.resources.OpenApiResource.class);
        
        return resources;
    }

        }