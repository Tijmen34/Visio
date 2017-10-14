/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.eyebeacon.resource;

/**
 * Create a list of Beacons for testing purposes.
 *
 * @author Erik Wolters <erik.wolters@hva.nl>
 */
@Deprecated
public class BeaconResource {

    private static final int AMOUNT_OF_TESTING_BEACONS = 3;
    private final Beacon[] BEACONS = new Beacon[AMOUNT_OF_TESTING_BEACONS];

    public BeaconResource() {
        BEACONS[0] = new Beacon("Entrance BPH", 52.359816, 4.909363);
        BEACONS[1] = new Beacon("Entrance WBH", 52.359182, 4.909577);
        BEACONS[2] = new Beacon("Subway Entrance Rhijnspoorplein", 52.360892, 4.908522);
    }
    
    public Beacon[] getBeacons() {
        return BEACONS;
    }
}
