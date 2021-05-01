package community.happenuponjava.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "locations")
public class Location extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long locationid;

    @Column(nullable = false)
    private long latitude;

    @Column(nullable = false)
    private long longitude;

    /**
     * Does every location need a name?
     */
    @Column(nullable = false)
    private String locationname;

    @Column()
    private String description;

    /**
     * Part of the join table creating userLocations model
     */
    @OneToMany(mappedBy = "locations",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    @JsonIgnoreProperties(value = "locations",
    allowSetters = true)
    private Set<UserLocations> userLocations = new HashSet<>();

    public Location() {
    }

    public Location(long latitude, long longitude, String locationname, String description) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationname = locationname;
        this.description = description;
    }

    public long getLocationid() {
        return locationid;
    }

    public void setLocationid(long locationid) {
        this.locationid = locationid;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public String getLocationname() {
        return locationname;
    }

    public void setLocationname(String locationname) {
        this.locationname = locationname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<UserLocations> getUserLocations() {
        return userLocations;
    }

    public void setUserLocations(Set<UserLocations> userLocations) {
        this.userLocations = userLocations;
    }
}
