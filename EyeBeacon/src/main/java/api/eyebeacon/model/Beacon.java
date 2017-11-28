package api.eyebeacon.model;

/**
 * Manage beacons
 *
 * @author Thijs Timmermans
 */
public class Beacon {

    public String UUID; // Display name for the beacond
    private int major;
    private int minor;
    private String name;
    private double latitude, longitude; // Geographical position of the 
    
    public Beacon() {
        
    }

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

    
}
