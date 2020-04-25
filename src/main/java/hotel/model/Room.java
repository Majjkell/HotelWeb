package hotel.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numOfPpl;
    private double price;
    private int rating;
    private int numberOfRoom;
    private boolean conferenceRoom;
    private String addInfo;
    private String typeRoom;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Busy> busies = new ArrayList<>();



    public Room() {
    }


    public List<Busy> getBusies() {
        return busies;
    }

    public void setBusies(List<Busy> busies) {
        this.busies = busies;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String add_info) {
        this.addInfo = add_info;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String type_room) {
        this.typeRoom = type_room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumOfPpl() {
        return numOfPpl;
    }

    public void setNumOfPpl(int num_of_ppl) {
        this.numOfPpl = num_of_ppl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(int number) {
        this.numberOfRoom = number;
    }

    public boolean isConferenceRoom() {
        return conferenceRoom;
    }

    public void setConferenceRoom(boolean conference_room) {
        this.conferenceRoom = conference_room;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", num_of_ppl=" + numOfPpl +
                ", price=" + price +
                ", rating=" + rating +
                ", number=" + numberOfRoom +
                ", conference_room=" + conferenceRoom +
                ", add_info='" + addInfo + '\'' +
                ", type_room='" + typeRoom + '\'' +
                ", busies=" + busies +
                '}';
    }
}
