package community.happenuponjava.models;

import org.codehaus.jackson.annotate.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;

    @Column(nullable = false,
    unique = true)
    private String username;

    @Column(nullable = false)
    // TODO: CHANGE PASSWORD TO WRITE ONLY
    @JsonProperty()
    private String password;

    // User image
    @Column()
    private String useravatar;

    /**
     * Not sure if we need phoneNumber here, come back to this
     */
    @Column(nullable = false,
    unique = true)
    private String phoneNumber;

    /**
     * Join relationship between users and locations in UserLocation model
     */
    @OneToMany(mappedBy = "user",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    @JsonIgnoreProperties(value = "user",
    allowSetters = true)
    private Set<UserLocations> userLocations = new HashSet<>();



    public User() {
    }

    public User(String username, String password, String useravatar, String phoneNumber) {
        setUsername(username);
        setPassword(password);
        this.useravatar = useravatar;
        this.phoneNumber = phoneNumber;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<UserLocations> getUserLocations() {
        return userLocations;
    }

    public void setUserLocations(Set<UserLocations> userLocations) {
        this.userLocations = userLocations;
    }

    public String getUseravatar() {
        return useravatar;
    }

    public void setUseravatar(String useravatar) {
        this.useravatar = useravatar;
    }
}
