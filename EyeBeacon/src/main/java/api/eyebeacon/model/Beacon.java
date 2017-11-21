package api.eyebeacon.model;

/**
 * Manage beacons
 *
 * @author Erik Wolters <erik.wolters@hva.nl>
 */
public class Beacon {

    private static int idGenerator = 0;

    private String UUID; // Display name for the beacond
    private int major;
    private int minor;
    private String name;
    private double latitude, longitude; // Geographical position of the beacon

    /**
     * Create a beacon
     *
     * @param UUID // Used to set the display name
     * @param latitude // Used to determine geographical position
     * @param longitude // Used to determine geographical position
     */
    public Beacon(String UUID, int Major, int Minor, String name, double latitude, double longitude) {
        this.UUID = UUID; // Set display name
        this.major = Major;
        this.minor = Minor;
        this.name = name;
        this.latitude = latitude; // Set geographical position
        this.longitude = longitude; // Set geographical position
    }

    public Beacon(String entrance_HvA__BPH, double d, double d0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUUID() {
        return UUID;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
