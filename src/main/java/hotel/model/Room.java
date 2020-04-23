package hotel.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int num_of_ppl;
    private double price;
    private int rating;
    private int number;
    private boolean conference_room;
    private String add_info;
    private String type_room;
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

    public String getAdd_info() {
        return add_info;
    }

    public void setAdd_info(String add_info) {
        this.add_info = add_info;
    }

    public String getType_room() {
        return type_room;
    }

    public void setType_room(String type_room) {
        this.type_room = type_room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNum_of_ppl() {
        return num_of_ppl;
    }

    public void setNum_of_ppl(int num_of_ppl) {
        this.num_of_ppl = num_of_ppl;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isConference_room() {
        return conference_room;
    }

    public void setConference_room(boolean conference_room) {
        this.conference_room = conference_room;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", num_of_ppl=" + num_of_ppl +
                ", price=" + price +
                ", rating=" + rating +
                ", number=" + number +
                ", conference_room=" + conference_room +
                ", add_info='" + add_info + '\'' +
                ", type_room='" + type_room + '\'' +
                ", busies=" + busies +
                '}';
    }
}
