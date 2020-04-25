package hotel.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Busy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateFrom;
    private Date dateTo;
    @ManyToOne(fetch = FetchType.EAGER)
    private Room room;

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
}
