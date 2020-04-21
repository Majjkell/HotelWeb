package hotel.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private Set<Room> room;
    @ManyToMany
    private Set<Guest> guest;
    private Date date_from;
    private Date date_to;
    private String add_info;



    public Reservation() {
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoom() {
        return (Room) room;
    }

    public void setRoom(Room room) {
        this.room = (Set<Room>) room;
    }

    public Guest getGuest() {
        return (Guest) guest;
    }

    public void setGuest(Guest guest) {
        this.guest = (Set<Guest>) guest;
    }

    public Date getDate_from() {
        return date_from;
    }

    public void setDate_from(Date date_from) {
        this.date_from = date_from;
    }

    public Date getDate_to() {
        return date_to;
    }

    public void setDate_to(Date date_to) {
        this.date_to = date_to;
    }

    public String getAdd_info() {
        return add_info;
    }

    public void setAdd_info(String add_info) {
        this.add_info = add_info;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", room=" + room +
                ", guest=" + guest +
                ", date_from=" + date_from +
                ", date_to=" + date_to +
                ", add_info='" + add_info + '\'' +
                '}';
    }
}
