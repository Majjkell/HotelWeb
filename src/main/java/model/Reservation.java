package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private Room room;
    @ManyToMany
    private Guest guest;
    private Date date_from;
    private Date date_to;
    private String add_info;



    public Reservation() {
    }

    public Reservation(Room room, Guest guest, Date date_from, Date date_to, String add_info) {
        this.room = room;
        this.guest = guest;
        this.date_from = date_from;
        this.date_to = date_to;
        this.add_info = add_info;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
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
