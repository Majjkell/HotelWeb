package hotel.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Room room;
    @ManyToMany
    private List<Guest> guest;
    private int num_of_ppl;
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_from;
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_to;
    private String add_info;
    private String room_type;


    public Reservation() {
    }



    public int getNum_of_ppl() {
        return num_of_ppl;
    }

    public void setNum_of_ppl(int num_of_ppl) {
        this.num_of_ppl = num_of_ppl;
    }

    public void setRoom(Set<Room> room) {
        this.room = (Room) room;
    }

    public void setGuest(Set<Guest> guest) {
        this.guest = (List<Guest>) guest;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
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
        this.room = (Room) room;
    }

    public List<Guest> getGuest() {
        return guest;
    }

    public void setGuest(List<Guest> guest) {
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
                ", num_of_ppl=" + num_of_ppl +
                ", date_from=" + date_from +
                ", date_to=" + date_to +
                ", add_info='" + add_info + '\'' +
                ", room_type='" + room_type + '\'' +
                '}';
    }
}
