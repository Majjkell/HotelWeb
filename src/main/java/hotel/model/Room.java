package hotel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int num_of_ppl;
    private double price;
    private int rating;
    private int number;
    private boolean conference_room;


    public Room() {
    }

    public Room(int num_of_ppl, double price, int rating, int number, boolean conference_room) {
        this.num_of_ppl = num_of_ppl;
        this.price = price;
        this.rating = rating;
        this.number = number;
        this.conference_room = conference_room;
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
