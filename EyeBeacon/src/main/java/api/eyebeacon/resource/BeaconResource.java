package api.eyebeacon.resource;

/**
 * Generate a hardcoded list of beacons for testing purposes
 * 
 * @author Erik Wolters <erik.wolters@hva.nl>
 * @deprecated Only used for testing
 */
@Deprecated
public class BeaconResource {

    // Determine the amount of testing beacons
    private static final int AMOUNT_OF_TESTING_BEACONS = 3;
    // Create the array to store testing beacons
    private final Beacon[] BEACONS = new Beacon[AMOUNT_OF_TESTING_BEACONS];

    /**
     * Generate testing beacons
     */
    public BeaconResource() {
        // Store hardcoded data in the test beacons
        BEACONS[0] = new Beacon("Entrance HvA - BPH", 52.359816, 4.909363);
        BEACONS[1] = new Beacon("Entrance HvA - WBH", 52.359182, 4.909577);
        BEACONS[2] = new Beacon("Subway Entrance Rhijnspoorplein", 52.360892,
                4.908522);
    }
    
    public Beacon[] getBeacons() {
        return BEACONS;
    }
}
