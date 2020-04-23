package hotel.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Busy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date_from;
    private Date date_to;
    @ManyToOne
    private Room room;

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
}
