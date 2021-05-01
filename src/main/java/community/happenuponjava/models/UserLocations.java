package community.happenuponjava.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userlocations")
@IdClass(UserLocations.class)
public class UserLocations
        extends Auditable
        implements Serializable
{
    /**
     * Half of the primary key for userLocations
     * Also a foreign key into users table
     */

    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "locations",
    allowSetters = true)
    private User user;

    /**
     * Half of the primary key for userLocations
     * Also a foreign key into locations table
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "locationid")
    @JsonIgnoreProperties(value = "users",
    allowSetters = true)
    private Location location;

    public UserLocations() {
    }

    public UserLocations(User user, Location location) {
        this.user = user;
        this.location = location;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
