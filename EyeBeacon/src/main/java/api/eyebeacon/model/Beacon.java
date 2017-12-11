package api.eyebeacon.model;

/**
 * Manage beacons
 *
 * @author Thijs Timmermans
 */
public class Beacon {

    public String id, Name, Description, Level, PlaceID; // Display Name for the beacond
    public double Latitude, Longitude; // Geographical position of the beacon
    
    public Beacon() {
        
    }

    public Beacon(String id, String Name, String Description, String Level, String PlaceID, double Latitude, double Longitude) {
        this.id = id;
        this.Name = Name;
        this.Description = Description;
        this.Level = Level;
        this.PlaceID = PlaceID;
        this.Latitude = Latitude;
        this.Longitude = Longitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String Level) {
        this.Level = Level;
    }

    public String getPlaceid() {
        return PlaceID;
    }

    public void setPlaceid(String PlaceID) {
        this.PlaceID = PlaceID;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double Latitude) {
        this.Latitude = Latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double Longitude) {
        this.Longitude = Longitude;
    }




    
}
