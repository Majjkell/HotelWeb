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
    private int numOfPpl;
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFrom;
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateTo;
    private String addInfo;
    private String roomType;


    public Reservation() {
    }



    public int getNumOfPpl() {
        return numOfPpl;
    }

    public void setNumOfPpl(int num_of_ppl) {
        this.numOfPpl = num_of_ppl;
    }

    public void setRoom(Set<Room> room) {
        this.room = (Room) room;
    }

    public void setGuest(Set<Guest> guest) {
        this.guest = (List<Guest>) guest;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String room_type) {
        this.roomType = room_type;
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

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date date_from) {
        this.dateFrom = date_from;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date date_to) {
        this.dateTo = date_to;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String add_info) {
        this.addInfo = add_info;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", room=" + room +
                ", num_of_ppl=" + numOfPpl +
                ", date_from=" + dateFrom +
                ", date_to=" + dateTo +
                ", add_info='" + addInfo + '\'' +
                ", room_type='" + roomType + '\'' +
                '}';
    }
}
