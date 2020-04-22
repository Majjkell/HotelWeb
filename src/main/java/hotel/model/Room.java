package hotel.model;

import javax.persistence.*;

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
    private String type;
    private boolean busy;


    public Room() {
    }



    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public String getAdd_info() {
        return add_info;
    }

    public void setAdd_info(String add_info) {
        this.add_info = add_info;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                '}';
    }
}
