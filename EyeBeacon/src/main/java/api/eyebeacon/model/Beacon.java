package api.eyebeacon.model;

/**
 * Manage beacons
 *
 * @author Erik Wolters <erik.wolters@hva.nl>
 */
public class Beacon {
    
    private static int idGenerator = 0;
    
    private int id; // unique identifier for the beacons
    private String name; // Display name for the beacond
    private double latitude, longitude; // Geographical position of the beacon

    /**
     * Create a beacon
     * 
     * @param name // Used to set the display name
     * @param latitude // Used to determine geographical position
     * @param longitude  // Used to determine geographical position
     */
    public Beacon(String name, double latitude, double longitude) {
        this.id = ++idGenerator; // Generate id
        this.name = name; // Set display name
        this.latitude = latitude; // Set geographical position
        this.longitude = longitude; // Set geographical position
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

    public double getLongitude() {
        return longitude;
    }
    
    /**
     * Reset the id to zero to avoid the system from generating unlimited
     * beacons
     */
    public static void resetId() {
        idGenerator = 0;
    }
}
