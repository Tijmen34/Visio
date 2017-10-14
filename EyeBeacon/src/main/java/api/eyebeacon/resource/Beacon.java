/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.eyebeacon.resource;

/**
 * Manage beacons
 *
 * @author Erik Wolters <erik.wolters@hva.nl>
 */
public class Beacon {
    
    private static int idGenerator = 0;
    
    private int id;
    private String name;
    private double latitude;
    private double longtitude;
    
    public Beacon(String name, double latitude, double longitude) {
        this.id = idGenerator++;
        this.name = name;
        this.latitude = latitude;
        this.longtitude = longitude;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }
}
